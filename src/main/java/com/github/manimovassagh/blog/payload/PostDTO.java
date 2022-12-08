package com.github.manimovassagh.blog.payload;

import lombok.Data;


@Data
public class PostDTO {

    private Long id;
    private  String title;
    private String description;
    private  String content;
}
