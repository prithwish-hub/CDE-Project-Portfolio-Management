package com.cts.authservice.service;

import com.cts.authservice.dto.AuthResponse;
import com.cts.authservice.dto.ValidationResponse;
import com.cts.authservice.entity.AppUserDetails;
import com.cts.authservice.exception.LoginException;
import com.cts.authservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<AuthResponse> login(String username, String password) throws LoginException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            AppUserDetails userDetails = (AppUserDetails) appUserService.loadUserByUsername(username);
            String jwtToken = jwtUtil.generateToken(userDetails);
            AuthResponse authResponse = new AuthResponse(userDetails.getUserId(), userDetails.getUsername(), jwtToken,
                    jwtUtil.getServerCurrentTime(), jwtUtil.getTokenExpirationTime());
            log.info("User successfully logged in");
            return ResponseEntity.ok(authResponse);
        } catch (Exception e) {
            log.error("Username or password is incorrect");
            throw new LoginException("Invalid Username Or Password");
        }
    }

    public ResponseEntity<ValidationResponse> validate(String jwtToken) {
        String token = jwtToken.substring(7);
        ValidationResponse response = new ValidationResponse();
        try {
            UserDetails user = appUserService.loadUserByUsername(jwtUtil.extractUsername(token));
            if (jwtUtil.validateToken(token, user)) {
                log.info("Jwt token is valid");
                response.setValid(true);
                return ResponseEntity.ok(response);
            } else {
                log.error("Invalid jwt token");
                response.setValid(false);
                return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            log.error("Incorrect jwt token : {}", e.getMessage());
            response.setValid(false);
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }
}
