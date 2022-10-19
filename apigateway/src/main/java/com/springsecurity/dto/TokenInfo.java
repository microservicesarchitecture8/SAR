package com.springsecurity.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TokenInfo class
 *
 * @author BGH58082
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo {
    private Long userId;
    private String token;
    private Date issuedAt;
    private Date expiresAt;
}
