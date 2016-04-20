package com.cc.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.admin.dao.HouseMapper;
import com.cc.admin.dao.PortMapper;
import com.cc.admin.dao.SeafoodMapper;
import com.cc.admin.dao.ShipMapper;
import com.cc.admin.dto.House;
import com.cc.admin.dto.Port;
import com.cc.admin.dto.Seafood;
import com.cc.admin.dto.Ship;
import com.utils.common.JPage;

@Service
@Transactional
public class SeafoodService {
	

	
	@Autowired
	private SeafoodMapper seafoodMapper;
	
	@Autowired
	private HouseMapper houseMapper;

	public List<Seafood> queryPage(int startNum,int pageCount){
		
		JPage page = new JPage();
		page.setStartNum(startNum);
		page.setPageCount(pageCount);
		return this.seafoodMapper.queryPage(page);
	}

	
	public Ship queryById(int id){
		
		return this.seafoodMapper.queryById(id);
		
	}
	
	public int count(){
		
		return this.seafoodMapper.getCount();
		
	}

	
	 public void updateStatus(Seafood seafood){
		 House house=this.houseMapper.query();
			
			if(seafood.getStatus().equals("in")){
				house.setRemained(house.getRemained()-seafood.getCount());
				house.setUsed(house.getUsed()+seafood.getCount());
				
				
			}else{
				
				house.setRemained(house.getRemained()+seafood.getCount());
				house.setUsed(house.getUsed()-seafood.getCount());
				
			}
			this.houseMapper.update(house);
		 
		 this.seafoodMapper.updateStatus(seafood);
	 }
	
	
	public void delete(int id){
	   this.seafoodMapper.delete(id);
	}


}