package com.ssafy.todo.model.mapper;


import com.ssafy.todo.dto.Todo;

import java.util.List;

public interface TodoMapper {
    List<Todo> getTodoList(int groupId);
    int update(Todo todo);
    int delete(int todoId);
    int insert(Todo todo);
  
}
