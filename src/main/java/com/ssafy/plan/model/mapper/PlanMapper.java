package com.ssafy.plan.model.mapper;

import java.util.List;

//import com.ssafy.plan.dto.Attraction;
import com.ssafy.plan.dto.Plan;
import com.ssafy.plan.dto.PlanAttraction;
import com.ssafy.plan.dto.Search;
import com.ssafy.plan.dto.Sido;
import com.ssafy.plan.dto.Type;


public interface PlanMapper {
	List<PlanAttraction> getPlans(int groupId);
    int update(Plan plan);
    int delete(int planId);
    int insert(Plan plan);
    
    List<Sido> getSido();
    List<Type> getType();
//    List<Attraction> getAttractions(SearchDto search);
}
