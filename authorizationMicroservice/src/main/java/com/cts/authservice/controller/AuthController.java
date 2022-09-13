package com.cts.authservice.controller;

import com.cts.authservice.dto.AuthRequest;
import com.cts.authservice.dto.AuthResponse;
import com.cts.authservice.dto.ValidationResponse;
import com.cts.authservice.exception.LoginException;
import com.cts.authservice.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@Api(value = "Login and validation endpoints for authorization microservice")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * http://localhost:8081/auth-service/login
     * Login user to the application and return appropriate jwt token
     *
     * @param request containing username and password
     * @return the response entity
     * @throws LoginException the login exception
     */
    @PostMapping("/login")
    @ApiOperation(value = "Login",
            notes = "Takes user credentials and generates the unique JWT for each user",
            httpMethod = "POST", response = ResponseEntity.class)
    public ResponseEntity<AuthResponse> login(@RequestBody @ApiParam(name = "AuthRequest", value = "Login credentials of the user") AuthRequest request)
            throws LoginException {

        log.info("START - Login request for user : {}", request.getUsername());
        ResponseEntity<AuthResponse> response = authService.login(request.getUsername(), request.getPassword());
        log.info("END - Login request");
        return response;

    }


    /**
     * http://localhost:8081/auth-service/validate
     * Validate the request by checking the validity of the jwt token
     *
     * @param jwtToken the jwt token
     * @return the response entity
     */
    @GetMapping("/validate")
    @ApiOperation(value = "Validate",
            notes = "Returns boolean after validating JWT",
            httpMethod = "GET", response = ResponseEntity.class)
    public ResponseEntity<ValidationResponse> validate(@RequestHeader(name = "Authorization") @ApiParam(name = "jwtToken", value = "Jwt Token of the user to check its validity") String jwtToken) {

        log.info("START - Validation request for token : {}", jwtToken);
        ResponseEntity<ValidationResponse> response = authService.validate(jwtToken);
        log.info("END - Validation request");
        return response;

    }
}
