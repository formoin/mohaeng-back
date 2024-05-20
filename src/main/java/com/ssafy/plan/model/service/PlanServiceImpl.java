package com.ssafy.plan.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.plan.dto.Attraction;
import com.ssafy.plan.dto.Plan;
import com.ssafy.plan.dto.PlanAttraction;
import com.ssafy.plan.dto.Search;
import com.ssafy.plan.dto.Sido;
import com.ssafy.plan.dto.Type;
import com.ssafy.plan.model.mapper.AttractionMapper;
import com.ssafy.plan.model.mapper.PlanMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
	
	private final PlanMapper planMapper;
	private final AttractionMapper attractionMapper;
	@Override
	public List<PlanAttraction> getPlans(int groupId) {
		return planMapper.getPlans(groupId);
	}

	@Override
	public int deletePlan(int planId) {
		return planMapper.delete(planId);
	}

	@Override
	public int makePlan(Plan plan) {
		return planMapper.insert(plan);
	}

	@Override
	public int updatePlan(Plan plan) {
		return planMapper.update(plan);
	}

	@Override
	public List<Sido> getSido() {
		return planMapper.getSido();
	}
	
	@Override
	public List<Type> getType() {
		return planMapper.getType();
	}


	@Override
	public List<Attraction> getAttractions(Search searchDto) {
		
		return attractionMapper.getAttractions(searchDto);
	}
	
	
}
