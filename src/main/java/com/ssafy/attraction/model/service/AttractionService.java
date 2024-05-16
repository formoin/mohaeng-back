package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.dto.Attraction;

public interface AttractionService {
	List<Attraction> getAttrList() throws Exception;

	Attraction getAttrInfo(int id) throws Exception;
}
