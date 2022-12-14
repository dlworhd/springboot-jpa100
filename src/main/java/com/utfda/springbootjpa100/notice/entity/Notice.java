package com.utfda.springbootjpa100.notice.entity;

import com.utfda.springbootjpa100.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column
    private String contents;

    @Column
    private LocalDateTime regDate;

    @Column
    private int hits; //조회수

    @Column
    private int likes; //좋아요

    @Column
    private LocalDateTime updateDate;

    @Column
    private boolean deleted;

    @Column
    private LocalDateTime deletedDate;
}
