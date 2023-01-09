package com.github.manimovassagh.blog.controller;


import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.APIResponse;
import com.github.manimovassagh.blog.repository.PostRepository;
import com.github.manimovassagh.blog.utils.SuccessFail;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TestController {
    private final PostRepository postRepository;


    @GetMapping("/testy")
    public APIResponse<Object> findAll(){
        List<Post> allPosts = postRepository.findAll();
        APIResponse<Object> responseResult = APIResponse.builder()
                .status(SuccessFail.SUCCESS)
                .result(allPosts).build();
         return responseResult;
    }
}
