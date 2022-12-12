package com.github.manimovassagh.blog.payload;

import com.github.manimovassagh.blog.entity.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;


@Data
public class PostDTO {

    private Long id;
    @NotEmpty
    @Size(min = 2,message = "Post title should have at least 2 characters")
    private  String title;
    @NotEmpty
    @Size(min = 10,message = "Post description should have at least 10 characters")

    private String description;
    @NotEmpty
    private  String content;

    private Set<CommentDto> comments;
}
