package com.cc.admin.dao;

import java.util.List;

import com.cc.admin.dto.Ship;
import com.utils.common.JPage;

public interface ShipMapper {
	
	/**
	 * 读取列表数据带分页信息
	 * @param page
	 * @return
	 */
	public List<Ship> queryPage(JPage page);

	
	/**
	 * 获取总数
	 * @return
	 */
	public int getCount();
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Ship queryById(int id);
	
	
	/**
	 * 更新船舶信息
	 * @param ship
	 */
	public void update(Ship ship);
	
	
	/**
	 * 更新船舶状态
	 * @param ship
	 */
	public void updateStatus(Ship ship);
	
	/**
	 * 删除船舶
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 新增船舶
	 * @param ship
	 */
    public void insert(Ship ship);

}