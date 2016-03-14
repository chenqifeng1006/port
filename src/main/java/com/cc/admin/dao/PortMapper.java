package com.cc.admin.dao;


import com.cc.admin.dto.Port;

public interface PortMapper {
	
	/**
	 * 读取列表数据带分页信息
	 * @param page
	 * @return
	 */
	public Port query();

	

	/**
	 * update
	 * @param ship
	 */
	public void update(Port port);
	
	
	
}