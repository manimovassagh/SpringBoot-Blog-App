package com.github.manimovassagh.blog.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {

    private long id;
    @NotEmpty(message = "name can not be Empty!")
    @Size(min = 2,message = "name can not be less than 2 characters")
    private String name;
    @NotEmpty
    @Email(message = "Caution:Please give a valid Email. Email should not be Null or Empty!")
    private String email;
    @NotEmpty(message = "body can not be Empty!")
    @Size(min = 4,message = "comment body can not be less than 4 characters")
    private String body;

}
