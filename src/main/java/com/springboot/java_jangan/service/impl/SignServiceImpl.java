package com.springboot.java_jangan.service.impl;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.common.CommonResponse;
import com.springboot.java_jangan.config.security.JwtTokenProvider;
import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.repository.UserRepository;
import com.springboot.java_jangan.service.SignService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service

public class SignServiceImpl implements SignService {
    private final Logger LOGGER = (Logger)LoggerFactory.getLogger(SignServiceImpl.class);

    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public SignServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SignUpResultDto signUp(String id,String password,String name, String auth) {

        LOGGER.info("[getSignUpResult] 회원 가입 정보 전달 userId:{}, userName:{},auth:{},test:{}",id,name,auth,auth.equalsIgnoreCase("admin"));
        User user;
        if (auth.equalsIgnoreCase("admin")) {
            user = User.builder()
                    .id(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .auth(Collections.singletonList("ROLE_ADMIN"))
                    .build();
        } else {
            user = User.builder()
                    .id(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .auth(Collections.singletonList("ROLE_USER"))
                    .build();
        }

        User savedUser = userRepository.save(user);
        SignUpResultDto signUpResultDto = new SignInResultDto();

        LOGGER.info("[getSignUpResult] userEntity 값이 들어왔는지 확인 후 결과값 주입");
        if(!savedUser.getUsername().isEmpty()){
            LOGGER.info("[getSignUpResult] 정상 처리 완료");
            setSuccessResult(signUpResultDto);
        }else {
            LOGGER.info("[getSignUpResult] 실패 처리 완료");
            setFailResult(signUpResultDto);
        }
        return signUpResultDto;
    }

    @Override
    public SignInResultDto signIn(String id,String password) throws RuntimeException{
        LOGGER.info("[getSignInResult] signDateHandler로 회원 정보 요청");
        User user = userRepository.getById(id);
        LOGGER.info("[getSignInResult] Id : {}",user);
        LOGGER.info("[getByID] id: {}",user);
        LOGGER.info("[getSignInResult] 패스워드 비교 수행");



        if(user == null || !passwordEncoder.matches(password, user.getPassword()))  {
            SignInResultDto signInResultDto = new SignInResultDto();

            LOGGER.info("[getSignInResult] in : {}",signInResultDto);
            setFailResult(signInResultDto);
            return signInResultDto;
        }else if(user != null && (passwordEncoder.matches(password, user.getPassword()))){
            LOGGER.info("[getSignInResult] 패스워드 일치");
            LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");
            SignInResultDto signInResultDto = SignInResultDto.builder()
                    .token(jwtTokenProvider.createToken(String.valueOf(user.getId()),user.getAuth()))
                    .build();

            LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입 lgoger: {}",signInResultDto);
            setSuccessResult(signInResultDto);
            return signInResultDto;
        }else{
            throw new RuntimeException();
        }

    }
    private void setSuccessResult(SignUpResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(SignUpResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }



}
