package com.utfda.springbootjpa100.notice.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoticeInput {

    @Size(min = 10, max = 100, message = "글자는 10자 이상 100자 이하입니다.")
    @NotBlank(message = "제목은 필수 항목입니다.")
    private String title;

    @NotBlank(message = "내용은 필수 항목입니다.")
    private String contents;

    private long id;
    private LocalDateTime regDt;



}
