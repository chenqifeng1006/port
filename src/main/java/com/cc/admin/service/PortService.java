package com.cc.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.admin.dao.PortMapper;
import com.cc.admin.dao.ShipMapper;
import com.cc.admin.dto.Port;
import com.cc.admin.dto.Ship;
import com.utils.common.JPage;

@Service
@Transactional
public class PortService {
	

	@Autowired
	private PortMapper portMapper;

	public Port query(){
		
	
		return this.portMapper.query();
	}

}