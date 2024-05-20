package com.ssafy.plan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.plan.dto.Attraction;
//import com.ssafy.plan.dto.Attraction;
import com.ssafy.plan.dto.Plan;
import com.ssafy.plan.dto.PlanAttraction;
import com.ssafy.plan.dto.Search;
import com.ssafy.plan.dto.Sido;
import com.ssafy.plan.dto.Type;
import com.ssafy.plan.model.service.PlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plans")
public class PlanController {
	
	private final PlanService planService;
	
	@GetMapping("/{groupId}")
	public ResponseEntity<?> getPlans(@PathVariable int groupId) throws Exception {
		System.out.println(groupId);
		List<PlanAttraction> plans = planService.getPlans(groupId);
		if(plans == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("계획 가져오기 실패");
		return ResponseEntity.ok(plans);
	}
	@PostMapping
	public ResponseEntity<?> makePlan(@RequestBody Plan plan) throws Exception {
		int cnt = planService.makePlan(plan);

		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("계획 추가 실패");
		return ResponseEntity.ok(cnt);
	}

	@PutMapping
	public ResponseEntity<?> updatePlan(@RequestBody Plan plan) throws Exception {
		int cnt = planService.updatePlan(plan);

		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("계획 업데이트 실패");
		return ResponseEntity.ok(cnt);
	}
	@DeleteMapping
	public ResponseEntity<?> deletePlan(@RequestParam("planId") int planId) throws Exception {

		int cnt=planService.deletePlan(planId);
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("계획 삭제 실패");
		return ResponseEntity.ok(cnt);
	}
	
	@GetMapping("/sido")
	public ResponseEntity<?> getLocation() throws Exception {
		
		List<Sido> sidoList = planService.getSido();
		if(sidoList == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("시도 리스트 가져오기 실패");
		return ResponseEntity.ok(sidoList);
	}
	
	@GetMapping("/type")
	public ResponseEntity<?> getType() throws Exception {
		
		List<Type> type = planService.getType();
		if(type == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("타입 리스트 가져오기 실패");
		return ResponseEntity.ok(type);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestBody Search searchDto) throws Exception {
		
		List<Attraction> attractions = planService.getAttractions(searchDto);
		if(attractions == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("타입 리스트 가져오기 실패");
		return ResponseEntity.ok(attractions);
	}
}
