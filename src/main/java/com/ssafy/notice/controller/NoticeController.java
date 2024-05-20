package com.ssafy.notice.controller;

import com.ssafy.notice.dto.Notice;
import com.ssafy.notice.model.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<?> noticeList(@RequestParam int groupId) throws Exception {
        List<Notice> list = noticeService.getNoticeList(groupId);

        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("공지 가져오기 실패");
        return new ResponseEntity<List<Notice>>(list, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int noticeId) throws Exception {
        int cnt = noticeService.deleteNotice(noticeId);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("공지 삭제 실패");
        return ResponseEntity.ok(cnt);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Notice notice) throws Exception {
        System.out.println(notice.getGroupId()+"!!!!");
    	int cnt = noticeService.createNotice(notice);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("공지 업데이트 실패");
        return ResponseEntity.ok(cnt);
    }

}
