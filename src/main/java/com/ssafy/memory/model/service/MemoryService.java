package com.ssafy.memory.model.service;


import com.ssafy.memory.dto.Memory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemoryService {
    List<Memory> getDiary(int groupId);
    int updateMemory(Memory memory);
    int deleteMemory(int memoryId);
    int upload(Memory memory);

}
