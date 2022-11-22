package com.utfda.springbootjpa100.notice.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoticeInput {

    private String title;
    private String contents;



}
