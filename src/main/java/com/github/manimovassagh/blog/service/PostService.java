package com.github.manimovassagh.blog.service;

import com.github.manimovassagh.blog.payload.PostDTO;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
}