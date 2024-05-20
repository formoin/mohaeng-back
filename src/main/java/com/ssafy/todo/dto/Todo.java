package com.ssafy.todo.dto;

import lombok.Data;

@Data
public class Todo {
    private int todoId;
    private String content;
    private boolean checked;
    private int groupId;
}
