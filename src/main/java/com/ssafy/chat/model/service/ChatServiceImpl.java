package com.ssafy.chat.model.service;

import com.ssafy.chat.dto.Chat;
import com.ssafy.chat.model.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{
    private final ChatMapper chatMapper;
    @Override
    public List<Chat> getChatting(int groupId) {
        return chatMapper.getChatting(groupId);
    }

    @Override
    public int deleteChat(int chatId) {
        return chatMapper.deleteChat(chatId);
    }

    @Override
    public int createChat(Chat chat) {
        return chatMapper.createChat(chat);
    }
}
