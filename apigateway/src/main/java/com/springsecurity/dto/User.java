package com.springsecurity.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User class
 *
 * @author BGH58082
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private Long id;
    private String username;
    private String password;
    private List<String> roles = new ArrayList();
    private String firstName;
    private String lastName;
    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public User(Long id, String username, String password) {
    	this.id=id;
    	this.username=username;
    	this.password=password;
    	this.enabled=true;
    	this.roles.add("admin");
    }
}
