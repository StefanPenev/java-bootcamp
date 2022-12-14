package com.bootcamp3.MoonlightHotelAndSpa.controller;

import com.bootcamp3.MoonlightHotelAndSpa.converter.UserConverter;
import com.bootcamp3.MoonlightHotelAndSpa.dto.authentication.AuthenticationRequest;
import com.bootcamp3.MoonlightHotelAndSpa.dto.authentication.AuthenticationResponse;
import com.bootcamp3.MoonlightHotelAndSpa.dto.user.UserResponse;
import com.bootcamp3.MoonlightHotelAndSpa.model.errormessage.ErrorResponse;
import com.bootcamp3.MoonlightHotelAndSpa.service.impl.LoginService;
import com.bootcamp3.MoonlightHotelAndSpa.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Login", description = "Login actions")
@CrossOrigin()
public class LoginController {

    private final LoginService loginService;
    private final UserServiceImpl userService;

    @Autowired
    public LoginController(LoginService loginService, UserServiceImpl userService) {
        this.loginService = loginService;
        this.userService = userService;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @Operation(summary = "Obtain a JWT Token",
               responses = {
                       @ApiResponse(
                               responseCode = "200",
                               description = "Successful Operation",
                               content = @Content(
                                       mediaType = "application/json",
                                       schema = @Schema(implementation = AuthenticationResponse.class)
                               )),
                       @ApiResponse(
                               responseCode = "400",
                               description = "Bad Request",
                               content = @Content(
                                       mediaType = "application/json",
                                       schema = @Schema(implementation = ErrorResponse.class)))
               })
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String token = loginService.login(authenticationRequest);
        UserResponse user = UserConverter
                .convertToUserResponse(userService.loadUserByUsername(authenticationRequest.getUsername()));

        return new ResponseEntity<>(new AuthenticationResponse(token, user), HttpStatus.OK);
    }
}
