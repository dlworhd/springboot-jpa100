package com.utfda.springbootjpa100.notice.model;

import com.utfda.springbootjpa100.notice.entity.Notice;
import com.utfda.springbootjpa100.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponse {

    private Long id;

    private Long regUserId;
    private String regUsername;


    private String title;
    private String contents;

    private int hits; //조회수
    private int likes; //좋아요

    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public static NoticeResponse of(Notice notice) {
        return NoticeResponse.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .contents(notice.getContents())
                .regDate(notice.getRegDate())
                .updateDate(notice.getUpdateDate())
                .regUserId(notice.getId())
                .regUsername(notice.getUser().getUsername())
                .hits(notice.getHits())
                .likes(notice.getLikes())
                .build();
    }
}

