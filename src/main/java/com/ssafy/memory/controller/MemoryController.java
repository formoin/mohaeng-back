package com.ssafy.memory.controller;

import com.ssafy.memory.dto.Memory;
import com.ssafy.memory.model.service.MemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memories")
@RequiredArgsConstructor
public class MemoryController {
    private final MemoryService memoryService;

    @GetMapping
    public ResponseEntity<?> diary(@RequestParam int groupId) throws Exception {
        List<Memory> list = memoryService.getDiary(groupId);

        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("다이어리 가져오기 실패");
        return new ResponseEntity<List<Memory>>(list, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteMemory(@RequestParam int memoryId) throws Exception {
        int cnt = memoryService.deleteMemory(memoryId);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("다이어리 삭제 실패");
        return ResponseEntity.ok(cnt);
    }

    @PostMapping
    public ResponseEntity<?> uploadMemory(@RequestBody Memory memory) throws Exception {
    	System.out.println("gtoupId " + memory.getGroupId());
        int cnt = memoryService.upload(memory);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("다이어리 업로드 실패");
        return ResponseEntity.ok(cnt);
    }

    @PutMapping
    public ResponseEntity<?> updateMemory(@RequestBody Memory memory) throws Exception {
        int cnt = memoryService.updateMemory(memory);

        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("메모리 수정 실패");
        return ResponseEntity.ok(cnt);
    }
}
