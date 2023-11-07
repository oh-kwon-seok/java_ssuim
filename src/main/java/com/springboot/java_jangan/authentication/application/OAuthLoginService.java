package com.springboot.java_jangan.authentication.application;
import com.springboot.java_jangan.authentication.domain.AuthTokens;
import com.springboot.java_jangan.authentication.domain.AuthTokensGenerator;
import com.springboot.java_jangan.authentication.domain.oauth.*;
import com.springboot.java_jangan.data.repository.SnsRepository;
import com.springboot.java_jangan.data.entity.Sns;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    private final SnsRepository snsRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long snsId = findOrCreateSns(oAuthInfoResponse);
        return authTokensGenerator.generate(snsId);
    }

    private Long findOrCreateSns(OAuthInfoResponse oAuthInfoResponse) {
        return (Long) snsRepository.findByEmail(oAuthInfoResponse.getEmail())

                .map(Sns::getId)
                .orElseGet(() -> newSns(oAuthInfoResponse));
    }

    private Long newSns(OAuthInfoResponse oAuthInfoResponse) {
        Sns sns = Sns.builder()
                 .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return snsRepository.save(sns).getId();
    }
}