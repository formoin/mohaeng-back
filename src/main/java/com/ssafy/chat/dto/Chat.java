package com.ssafy.chat.dto;

import lombok.Data;

@Data
public class Chat {

    private int chatId;
    private String content;
    private String writeTime;
    private int userId;
    private int groupId;

}