package com.github.manimovassagh.blog.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.manimovassagh.blog.utils.SuccessFail;
import lombok.*;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class APIResponse <T>{
    private SuccessFail status;
    private List<RuntimeException> errors;
    private T result;
}
