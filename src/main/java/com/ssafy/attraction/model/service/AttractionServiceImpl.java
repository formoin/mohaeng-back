//package com.ssafy.attraction.model.service;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.ssafy.attraction.dto.Attraction;
//import com.ssafy.attraction.model.mapper.AttractionMapper;
//
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class AttractionServiceImpl implements AttractionService {
//
//	private final AttractionMapper attractionMapper;
//	@Override
//	public List<Attraction> getAttrList() throws Exception {
//		
//		return attractionMapper.getAttrList();
//	}
//
//	@Override
//	public Attraction getAttrInfo(int id) throws SQLException {
//		return attractionMapper.getAttrInfo(id);
//	}
//
//}
