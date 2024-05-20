package com.ssafy.group.dto;

import java.util.List;

import lombok.Data;

@Data
public class MakegroupRequest {
	private Group groupInfo;
	private List<Integer> userList;
}
