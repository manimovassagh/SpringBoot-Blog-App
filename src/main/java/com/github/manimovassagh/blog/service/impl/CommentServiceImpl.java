package com.github.manimovassagh.blog.service.impl;

import com.github.manimovassagh.blog.payload.CommentDto;
import com.github.manimovassagh.blog.service.CommentService;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        return null;
    }
}
