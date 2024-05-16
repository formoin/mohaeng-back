package com.ssafy.group.dto;

import lombok.Data;

@Data
public class Group {
	private int groupId;
	private String groupName;
	private String groupTitle;
	private String groupImg;
	private String startDate;
	private String endDate;
	private int totalCnt;
	private int todayCnt;
	
}
