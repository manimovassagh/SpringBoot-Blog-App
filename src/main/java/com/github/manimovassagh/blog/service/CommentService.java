package com.github.manimovassagh.blog.service;

import com.github.manimovassagh.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId,CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(long postId,long commentId);

    CommentDto updateComment(Long postId,Long commentId,CommentDto commentDto);
}
