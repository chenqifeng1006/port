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
public class ShipService {
	

	
	@Autowired
	private ShipMapper shipMapper;
	
	@Autowired
	private PortMapper portMapper;

	public List<Ship> queryPage(int startNum,int pageCount){
		
		JPage page = new JPage();
		page.setStartNum(startNum);
		page.setPageCount(pageCount);
		return this.shipMapper.queryPage(page);
	}

	
	public Ship queryById(int id){
		
		return this.shipMapper.queryById(id);
		
	}
	
	public int count(){
		
		return this.shipMapper.getCount();
		
	}
	 public void update(Ship ship){
		 this.shipMapper.update(ship);
	 }
	
	 
	 public void updateStatus(Ship ship){
		 Port port=this.portMapper.query();
			
			if(ship.getStatus().equals("在港")){
				port.setRemained(port.getRemained()-1);
				port.setUsed(port.getUsed()+1);
				
				
			}else{
				
				port.setRemained(port.getRemained()+1);
				port.setUsed(port.getUsed()-1);
				
			}
			this.portMapper.update(port);
		 
		 this.shipMapper.updateStatus(ship);
	 }
	
	
	public void delete(int id){
	   this.shipMapper.delete(id);
	}

	public void insert(Ship ship){
		
		Port port=this.portMapper.query();
		
		if(ship.getStatus().equals("在港")){
			port.setRemained(port.getRemained()-1);
			port.setUsed(port.getUsed()+1);
			
			this.portMapper.update(port);
		}
		this.shipMapper.insert(ship);
	}
	
}