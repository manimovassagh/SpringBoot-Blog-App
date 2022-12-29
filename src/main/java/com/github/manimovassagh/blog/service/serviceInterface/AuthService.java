package com.github.manimovassagh.blog.service.serviceInterface;

import com.github.manimovassagh.blog.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
