package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.entity.User;
import com.springboot.java_jangan.service.SignService;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.v3.oas.annotations.Parameter;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // 🌟 추가

@RequestMapping("/sign-api")
public class SignController {
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @Autowired
    public SignController(SignService signService){
        this.signService = signService;
    }

    @PostMapping(value= "/sign-up")
    public SignUpResultDto signUp(
            @Parameter(name= "id", in = ParameterIn.QUERY) @RequestParam String id,
            @Parameter(name= "password") @RequestParam String password,
            @Parameter(name= "name") @RequestParam String name,
            @Parameter(name= "auth") @RequestParam String auth) throws RuntimeException {

        LOGGER.info("[signUp] 회원가입을 수행합니다.id: {}, passsword : ****, name : {}, role : {}",id,name,auth);
        SignUpResultDto signUpResultDto = signService.signUp(id,password,name,auth);
        LOGGER.info("[signUp] 회원가입을 완료했습니다.id:{}",id);
        return signUpResultDto;
    }


    @PostMapping(value= "/sign-in", consumes = "application/json", produces = "application/json")
    public SignInResultDto signIn(
            @RequestBody User user
    ) throws RuntimeException {

        LOGGER.info("[signIn] 로그인을 시도하고 있습니다.id: {}, pw: ****", user.getId());
        SignInResultDto signInResultDto = signService.signIn(user.getId(), user.getPassword());
        if(signInResultDto.getCode() == 0){
            LOGGER.info("[signIn] 정상적으로 로그인되었습니다.id: {}, token : {}",user.getId(), signInResultDto.getToken());
        }
        return signInResultDto;
    }



    @GetMapping(value= "/exception")
    public void exceptionTest() throws RuntimeException {
        throw new RuntimeException("접근이 금지되었습니다.");

    }


    @ExceptionHandler(value= RuntimeException.class)
    public ResponseEntity<Map<String,String>>  ExceptionHandler(RuntimeException e){
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "appication/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        LOGGER.error("ExceptionHandler 호출,{},{}", e.getCause(),e.getMessage());
        Map<String,String> map = new HashMap<>();
        map.put("error type",httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message","에러 발생");

        return new ResponseEntity<>(map,responseHeaders,httpStatus);

    }


}
