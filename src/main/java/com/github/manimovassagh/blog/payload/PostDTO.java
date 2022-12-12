package com.github.manimovassagh.blog.payload;

import com.github.manimovassagh.blog.entity.Comment;
import lombok.Data;

import java.util.Set;


@Data
public class PostDTO {

    private Long id;
    private  String title;
    private String description;
    private  String content;

    private Set<CommentDto> comments;
}
