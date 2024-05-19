package com.ssafy.notice.model.service;

import com.ssafy.notice.dto.Notice;
import com.ssafy.notice.model.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
    private final NoticeMapper noticeMapper;
    @Override
    public List<Notice> getNoticeList(int groupId) {
        return noticeMapper.getNoticeList(groupId);
    }

    @Override
    public int deleteNotice(int noticeId) {
        return noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public int createNotice(Notice notice) {
        return noticeMapper.createNotice(notice);
    }
}
