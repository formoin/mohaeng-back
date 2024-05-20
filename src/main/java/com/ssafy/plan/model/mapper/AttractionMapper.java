package com.ssafy.plan.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.plan.dto.Attraction;
import com.ssafy.plan.dto.Search;

public interface AttractionMapper {

	List<Attraction> getAttractions(Search search);
	
	Attraction getAttrInfo(int id);
	
}
