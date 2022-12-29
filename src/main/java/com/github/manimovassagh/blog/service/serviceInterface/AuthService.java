package com.github.manimovassagh.blog.service.serviceInterface;

import com.github.manimovassagh.blog.payload.LoginDto;
import com.github.manimovassagh.blog.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
