package com.ssafy.chat.model.service;

import com.ssafy.chat.dto.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> getChatting(int groupId);
    int deleteChat(int chatId);
    int createChat(Chat chat);

}
