package com.ssafy.plan.model.service;

import java.util.List;

import com.ssafy.plan.dto.Attraction;
//import com.ssafy.plan.dto.Attraction;
import com.ssafy.plan.dto.Plan;
import com.ssafy.plan.dto.PlanAttraction;
import com.ssafy.plan.dto.Search;
import com.ssafy.plan.dto.Sido;
import com.ssafy.plan.dto.Type;

public interface PlanService {
	List<PlanAttraction> getPlans(int groupId);
	int deletePlan(int planId);
	int makePlan(Plan plan);
	int updatePlan(Plan plan);
	
	List<Sido> getSido();
	List<Type> getType();
	List<Attraction> getAttractions(Search searchDto);
}
