package com.ssafy.memory.dto;


import lombok.Data;


@Data
public class Memory {
    private int memoryId;
    private String img;
    private String content;
    private String writeTime;
    private int groupId;
    private int userId;
}
