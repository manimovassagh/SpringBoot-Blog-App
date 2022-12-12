package com.github.manimovassagh.blog.payload;


import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

}
