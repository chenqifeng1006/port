package com.cc.admin.dao;

import java.util.List;

import com.cc.admin.dto.Seafood;
import com.cc.admin.dto.Ship;
import com.utils.common.JPage;

public interface SeafoodMapper {
	
	/**
	 * 读取列表数据带分页信息
	 * @param page
	 * @return
	 */
	public List<Seafood> queryPage(JPage page);

	
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
	public void update(Seafood seafood);
	
	
	/**
	 * 更新船舶状态
	 * @param ship
	 */
	public void updateStatus(Seafood seafood);
	
	/**
	 * 删除船舶
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 新增船舶
	 * @param ship
	 */
    public void insert(Seafood seafood);

}