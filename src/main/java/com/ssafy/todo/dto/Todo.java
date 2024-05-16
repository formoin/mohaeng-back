package com.ssafy.todo.dto;

import lombok.Data;

@Data
public class Todo {
    private int todoId;
    private String content;
    private boolean isChecked;
    private int groupId;
}
