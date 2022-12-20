package com.github.manimovassagh.blog.controller;

import com.github.manimovassagh.blog.payload.CommentDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommentControllerInterface {
    @PostMapping("/posts/{postId}/comments")
    ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId, @Valid @RequestBody CommentDto commentDto);

    @GetMapping("/posts/{postId}/comments")
    List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId);

    @GetMapping("/posts/{postId}/comments/{commentId}")
    ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId
            , @PathVariable(value = "commentId") Long commentId);

    @PutMapping("/posts/{postId}/comments/{commentId}")
    ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId
            , @PathVariable(value = "commentId") Long commentId, @Valid @RequestBody CommentDto commentDto);

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId, @PathVariable(value = "commentId") Long commentId);
}
