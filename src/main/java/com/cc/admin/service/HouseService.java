package com.cc.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.admin.dao.HouseMapper;
import com.cc.admin.dto.House;

@Service
@Transactional
public class HouseService {
	

	@Autowired
	private HouseMapper houseMapper;

	public House query(){
		
	
		return this.houseMapper.query();
	}

}