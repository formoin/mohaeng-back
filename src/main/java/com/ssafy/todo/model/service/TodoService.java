package com.ssafy.todo.model.service;

import com.ssafy.todo.dto.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodoList(int groupId);
    int checkTodo(Todo todo);
    int deleteTodo(int todoId);
    int registTodo(Todo todo);
}
