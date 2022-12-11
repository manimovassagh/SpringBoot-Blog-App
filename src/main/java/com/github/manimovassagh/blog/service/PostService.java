package com.github.manimovassagh.blog.service;

import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.PostDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts(int pageNo,int pageSize);
    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO post,long id);

    void deletePostById(long id);
}