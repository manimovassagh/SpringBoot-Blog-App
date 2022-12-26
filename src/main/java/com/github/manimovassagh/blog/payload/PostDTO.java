package com.github.manimovassagh.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;


@Data
public class PostDTO {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")

    private String description;
    @NotEmpty
    @Size(min = 2, message = "Post content should have at least 2 characters")
    @Size(min = 1, message = "Post content should not be Empty! ")
    private String content;

    private Set<CommentDto> comments;
}
