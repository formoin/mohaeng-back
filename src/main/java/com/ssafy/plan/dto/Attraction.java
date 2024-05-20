package com.ssafy.plan.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Attraction {
	private int contentId;
	private int contentTypeId;
	private String title;
	private String addr1;
	private String addr2;
	private String tel;
	private String firstImage;
	private int readcount;
	private int sidoCode;
	private int gugunCode;
	private BigDecimal latitude;
	private BigDecimal longitude;
}
