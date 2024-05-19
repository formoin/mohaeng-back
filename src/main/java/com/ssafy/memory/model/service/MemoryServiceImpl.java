package com.ssafy.memory.model.service;

import com.ssafy.memory.dto.Memory;
import com.ssafy.memory.model.mapper.MemoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryServiceImpl implements MemoryService {
    private MemoryMapper memoryMapper;
    @Override
    public List<Memory> getDiary(int groupId) {
        return memoryMapper.getDiary(groupId);
    }

    @Override
    public int updateMemory(Memory memory) {
        return memoryMapper.insert(memory);
    }

    @Override
    public int deleteMemory(int memoryId) {
        return memoryMapper.delete(memoryId);
    }

    @Override
    public int upload(Memory memory) {
        return memoryMapper.insert(memory);
    }
}
