//package com.ssafy.attraction.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ssafy.attraction.dto.Attraction;
//import com.ssafy.attraction.model.service.AttractionService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/attrs")
//@RequiredArgsConstructor
//public class AttractionController {
//	private final AttractionService attractionService;
//	
//	@GetMapping("/list")
//	public ResponseEntity<?> attrList() throws Exception {
//		List<Attraction> list = attractionService.getAttrList();
//		return new ResponseEntity<List<Attraction>>(list, HttpStatus.OK);
//	}
//	
//	@GetMapping("/info")
//	public ResponseEntity<?> attrInfo(@RequestParam int id) throws Exception {
//		Attraction attrInfo = attractionService.getAttrInfo(id);
//
//		if(attrInfo == null ) System.out.println("!!");
//		return ResponseEntity.ok(attrInfo);
//	}
//}
