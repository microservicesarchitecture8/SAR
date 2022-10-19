package com.springsecurity.configuration;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.springsecurity.dto.User;

import reactor.core.publisher.Mono;

/**
 * AuthenticationManager class
 * It is used in AuthenticationFilter.
 *
 * @author BGH58082
 */
@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        var principal = (UserPrincipal) authentication.getPrincipal();

        //TODO add more user validation logic here.
        return Mono.just(new User(Long.valueOf(1), "admin", "admin"))
                .filter(user -> user.isEnabled())
                .switchIfEmpty(Mono.error(new UnauthorizedException("User account is disabled.")))
                .map(user -> authentication);
    }
}
