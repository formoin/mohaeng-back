package com.ssafy.plan.dto;

import lombok.Data;

@Data
public class PlanAttraction {
	private int planId;
	private String date;
	private int groupId;
	private String title;
	private String addr1;
	private String firstImg;
	private String contentTypeName;
}
