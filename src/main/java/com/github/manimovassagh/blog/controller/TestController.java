package com.github.manimovassagh.blog.controller;


import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.APIResponse;
import com.github.manimovassagh.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final PostRepository postRepository;


    @GetMapping("/testy")
    public APIResponse<List<Post>> findAll(){
        List<Post> allPosts = postRepository.findAll();
         APIResponse<List<Post>> response=new APIResponse();
         response.setStatus("SUCCESS");
         response.setErrors(null);
         response.setResult(allPosts);
         return response;

    }


}
