package com.ssafy.chat.controller;

import com.ssafy.chat.dto.Chat;
import com.ssafy.chat.model.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<?> noticeList(@RequestParam int groupId) throws Exception {
        List<Chat> list = chatService.getChatting(groupId);

        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("공지 가져오기 실패");
        return new ResponseEntity<List<Chat>>(list, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int chatId) throws Exception {
        int cnt = chatService.deleteChat(chatId);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("공지 삭제 실패");
        return ResponseEntity.ok(cnt);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Chat chat) throws Exception {
        int cnt = chatService.createChat(chat);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("공지 업데이트 실패");
        return ResponseEntity.ok(cnt);
    }
}
