package com.github.manimovassagh.blog.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class APIResponse <T>{
    private String status;
    private List<RuntimeException> errors;
    private T result;
}
