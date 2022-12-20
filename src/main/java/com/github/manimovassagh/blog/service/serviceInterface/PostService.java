package com.github.manimovassagh.blog.service.serviceInterface;

import com.github.manimovassagh.blog.entity.Post;
import com.github.manimovassagh.blog.payload.PostDTO;
import com.github.manimovassagh.blog.payload.PostResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir);
    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO post,long id);

    void deletePostById(long id);
}