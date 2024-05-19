package com.ssafy.notice.model.service;

import com.ssafy.notice.dto.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeList(int groupId);
    int deleteNotice(int noticeId);
    int createNotice(Notice notice);
}
