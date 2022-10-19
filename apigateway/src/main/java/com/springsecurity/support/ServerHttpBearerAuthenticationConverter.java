package com.springsecurity.support;

import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.web.server.ServerWebExchange;

import com.springsecurity.configuration.CurrentUserAuthenticationBearer;

import reactor.core.publisher.Mono;

/**
 * ServerHttpBearerAuthenticationConverter class
 * This is a Converter that validates TOKEN against requests coming from AuthenticationFilter ServerWebExchange.
 *
 * @author BGH58082
 */
public class ServerHttpBearerAuthenticationConverter implements Function<ServerWebExchange, Mono<Authentication>> {
    private static final String BEARER = "Bearer ";
    private static final Predicate<String> matchBearerLength = authValue -> authValue.length() > BEARER.length();
    private static final Function<String, Mono<String>> isolateBearerValue = authValue -> Mono.justOrEmpty(authValue.substring(BEARER.length()));
    private final JwtVerifyHandler jwtVerifier;

    public ServerHttpBearerAuthenticationConverter(JwtVerifyHandler jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    @Override
    public Mono<Authentication> apply(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange)
                .flatMap(ServerHttpBearerAuthenticationConverter::extract)
                .filter(matchBearerLength)
                .flatMap(isolateBearerValue)
                .flatMap(jwtVerifier::check)
                .flatMap(CurrentUserAuthenticationBearer::create);
    }

    public static Mono<String> extract(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION));
    }
}
