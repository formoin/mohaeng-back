package com.ssafy.notice.dto;

import lombok.Data;

@Data
public class Notice {
    private int noticeId;
    private int groupId;
    private String content;
}
