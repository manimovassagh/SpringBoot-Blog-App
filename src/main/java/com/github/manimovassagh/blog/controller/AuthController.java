package com.github.manimovassagh.blog.controller;


import com.github.manimovassagh.blog.payload.LoginDto;
import com.github.manimovassagh.blog.service.serviceInterface.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
private final AuthService authService;


@PostMapping("login")
public ResponseEntity<String> login(LoginDto loginDto){
    String response = authService.login(loginDto);
    return new ResponseEntity<>( response,HttpStatus.OK);
    //return ResponseEntity.ok(response);
}

}
