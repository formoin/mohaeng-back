package com.ssafy.plan.dto;

import lombok.Data;

@Data
public class Search {
	private int sidoCode;
	private int contentTypeId;
	
	private String keyword;
}
