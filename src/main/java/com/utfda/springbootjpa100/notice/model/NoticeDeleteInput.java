package com.utfda.springbootjpa100.notice.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
public class NoticeDeleteInput {

    private List<Long>  idList;
}
