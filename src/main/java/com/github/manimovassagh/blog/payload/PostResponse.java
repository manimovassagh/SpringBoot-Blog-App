package com.github.manimovassagh.blog.payload;

import lombok.Data;

import java.util.List;


@Data
public class PostResponse {
    private List<PostDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}
