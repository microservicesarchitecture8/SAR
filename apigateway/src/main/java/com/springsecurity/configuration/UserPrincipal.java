package com.springsecurity.configuration;

import java.security.Principal;

/**
 * UserPrincipal class
 *
 * @author BGH58082
 */
public class UserPrincipal implements Principal {
    private Long id;
    private String name;

    public UserPrincipal(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
