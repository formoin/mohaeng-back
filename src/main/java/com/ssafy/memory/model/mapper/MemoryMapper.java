package com.ssafy.memory.model.mapper;

import com.ssafy.memory.dto.Memory;

import java.util.List;

public interface MemoryMapper {
    List<Memory> getDiary(int groupId);
    int update(Memory memory);
    int delete(int todoId);
    int insert(Memory memory);
}
