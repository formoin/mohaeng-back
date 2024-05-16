package com.ssafy.notice.model.mapper;

import com.ssafy.notice.dto.Notice;

import java.util.List;

public interface NoticeMapper {
    List<Notice> getNoticeList(int groupId);
    int deleteNotice(int id);
    int createNotice(Notice notice);
}
