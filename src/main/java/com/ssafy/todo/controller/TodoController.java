package com.ssafy.todo.controller;

import com.ssafy.todo.dto.Todo;
import com.ssafy.todo.model.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<?> todoList(@RequestParam int groupId) throws Exception {
        List<Todo> list = todoService.getTodoList(groupId);

        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("투두리스트 가져오기 실패");
        return new ResponseEntity<List<Todo>>(list, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@RequestParam int todoId) throws Exception {
        int cnt = todoService.deleteTodo(todoId);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("투두리스트 삭제 실패");
        return ResponseEntity.ok(cnt);
    }

    @PostMapping
    public ResponseEntity<?> registerTodo(@RequestBody Todo todo) throws Exception {
        int cnt = todoService.registTodo(todo);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("투두리스트 등록 실패");
        return ResponseEntity.ok(cnt);
    }

    @PutMapping
    public ResponseEntity<?> checkTodo(@RequestBody Todo todo) throws Exception {
        int cnt = todoService.checkTodo(todo);
        System.out.println(todo.isChecked()+"   !!!");
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("투두리스트 체크 실패");
        return ResponseEntity.ok(cnt);
    }
}
