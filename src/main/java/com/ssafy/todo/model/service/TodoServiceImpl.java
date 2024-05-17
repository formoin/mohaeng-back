package com.ssafy.todo.model.service;

import com.ssafy.todo.dto.Todo;
import com.ssafy.todo.model.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;
    @Override
    public List<Todo> getTodoList(int groupId) {
        return todoMapper.getTodoList(groupId);
    }

    @Override
    public int checkTodo(Todo todo) {
        return todoMapper.update(todo);
    }

    @Override
    public int deleteTodo(int todoId) {
        return todoMapper.delete(todoId);
    }

    @Override
    public int registTodo(Todo todo) {
        return todoMapper.insert(todo);
    }
}
