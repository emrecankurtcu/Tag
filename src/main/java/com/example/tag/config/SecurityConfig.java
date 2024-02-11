package com.example.tag.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${spring.google.client-id}")
    private String googleClienId;
    @Value("${spring.google.client-secret}")
    private String googleClientSecret;
    @Value("${spring.google.redirect-uri}")
    private String googleRedirectUri;
    @Value("${spring.google.auth-uri}")
    private String googleAuthUri;
    @Value("${spring.google.token-uri}")
    private String googleTokenUri;
    @Value("${spring.google.user-info-uri}")
    private String googleUserInfoUri;
    @Value("${spring.google.jwt-uri}")
    private String googleJwtUri;
    @Value("${spring.google.client-name}")
    private String googleClientName;
    @Value("${spring.google.client-registration-id}")
    private String googleClientRegistrationId;

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        {
                            auth.requestMatchers("/login/**").permitAll();
                            auth.anyRequest().authenticated();
                        }
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .defaultSuccessUrl("/login/google/ok")
                );
        return http.build();
    }


    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId(googleClientRegistrationId)
                .clientId(googleClienId)
                .clientSecret(googleClientSecret)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri(googleRedirectUri)
                .scope("openid", "profile", "email", "address", "phone")
                .authorizationUri(googleAuthUri)
                .tokenUri(googleTokenUri)
                .userInfoUri(googleUserInfoUri)
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri(googleJwtUri)
                .clientName(googleClientName)
                .build();
    }
}
