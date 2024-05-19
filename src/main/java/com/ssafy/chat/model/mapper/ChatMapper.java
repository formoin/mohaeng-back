package com.ssafy.chat.model.mapper;


import com.ssafy.chat.dto.Chat;

import java.util.List;

public interface ChatMapper {
    List<Chat> getChatting(int groupId);
    int deleteChat(int chatId);
    int createChat(Chat chat);
}

