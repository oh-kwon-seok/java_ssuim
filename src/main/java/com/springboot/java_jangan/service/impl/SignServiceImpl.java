package com.springboot.java_jangan.service.impl;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.common.CommonResponse;
import com.springboot.java_jangan.config.security.JwtTokenProvider;
import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.dto.car.CarDto;
import com.springboot.java_jangan.data.dto.user.UserDto;
import com.springboot.java_jangan.data.entity.Car;
import com.springboot.java_jangan.data.entity.Unit;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.data.repository.UserRepository;
import com.springboot.java_jangan.data.repository.car.CarRepository;
import com.springboot.java_jangan.service.SignService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service

public class SignServiceImpl implements SignService {
    private final Logger LOGGER = (Logger)LoggerFactory.getLogger(SignServiceImpl.class);



    public UserRepository userRepository;
    public CarRepository carRepository;

    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public SignServiceImpl(UserRepository userRepository, CarRepository carRepository,JwtTokenProvider jwtTokenProvider,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public  SignUpResultDto signUp(UserDto userDto) throws RuntimeException{
        String id = userDto.getId();
        String code = userDto.getCode();
        String name = userDto.getName();
        String password = userDto.getPassword();

        String email = userDto.getEmail();
        String phone = userDto.getPhone();
        String auth = userDto.getAuth();


        Car car = carRepository.findByUid(Long.valueOf(userDto.getCar_uid()));
        Optional<User> selectedUser = Optional.ofNullable(userRepository.getById(userDto.getId()));

        LOGGER.info("[selectUser] : {}",selectedUser.isPresent());

        User user;
        SignUpResultDto signUpResultDto = new SignUpResultDto();

        if(selectedUser.isPresent()){

            setFailResult(signUpResultDto);
            return signUpResultDto;

        }else{
            if (auth.equalsIgnoreCase("admin")) {
                user = User.builder()
                        .id(id)
                        .code(code)
                        .name(name)
                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .phone(phone)
                        .car(car)
                        .auth(Collections.singletonList("ROLE_ADMIN"))
                        .created(LocalDateTime.now())
                        .used(1)
                        .build();
                userRepository.save(user);

                setSuccessResult(signUpResultDto);
                return signUpResultDto;

            } else if(auth.equalsIgnoreCase("user")){
                user = User.builder()
                        .id(id)
                        .code(code)
                        .name(name)
                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .phone(phone)
                        .car(car)
                        .auth(Collections.singletonList("ROLE_USER"))
                        .created(LocalDateTime.now())
                        .used(1)
                        .build();
                userRepository.save(user);
                setSuccessResult(signUpResultDto);
                return signUpResultDto;
            }else{
                throw new RuntimeException();
            }

        }


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
