package com.github.manimovassagh.blog.service;

import com.github.manimovassagh.blog.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(long postId,CommentDto commentDto);
}
