package com.cts.authservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthResponse {
    private String userId;
    private String username;
    private String jwtToken;
    private Long serverCurrentTime;
    private Long tokenExpirationTime;
}
