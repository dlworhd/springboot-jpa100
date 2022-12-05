package com.utfda.springbootjpa100.notice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseError {


    //어떤 필드에서 어떤 에러가 났는지
    private String field;
    private String message;


    public static ResponseError of(FieldError e){
        return ResponseError.builder()
                .field(e.getField())
                .message(e.getDefaultMessage())
                .build();
    }
}
