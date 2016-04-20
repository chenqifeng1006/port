package com.cc.admin.dao;


import com.cc.admin.dto.House;

public interface HouseMapper {
	
	/**
	 * 读取列表数据带分页信息
	 * @param page
	 * @return
	 */
	public House query();

	

	/**
	 * update
	 * @param ship
	 */
	public void update(House port);
	
	
	
}