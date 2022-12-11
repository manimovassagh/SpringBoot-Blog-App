package com.github.manimovassagh.blog.controller;


import com.github.manimovassagh.blog.payload.PostDTO;
import com.github.manimovassagh.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;


    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }


    /**
     * Get all Posts from the database and send it as DTO to user
     *
     * @return list of post DTO
     */
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable(name = "id") long id) {

        return ResponseEntity.ok(postService.updatePost(postDTO, id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id")  long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok("Post successfully delete with id Number " + id);
    }


}
