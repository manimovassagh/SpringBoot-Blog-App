package com.github.manimovassagh.blog.controller;


import com.github.manimovassagh.blog.payload.JwtAuthResponse;
import com.github.manimovassagh.blog.payload.LoginDto;
import com.github.manimovassagh.blog.payload.RegisterDto;
import com.github.manimovassagh.blog.service.serviceInterface.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
@PostMapping(value = {"login","signin"})
@CrossOrigin
public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
    String token = authService.login(loginDto);

    JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
    jwtAuthResponse.setAccessToken(token);

    return ResponseEntity.ok(jwtAuthResponse);

}


    //build register Rest Api
    @PostMapping(value = {"register","signup"})
    public  ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
