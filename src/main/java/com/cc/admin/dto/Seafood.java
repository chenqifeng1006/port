package com.cc.admin.dto;

import java.util.Date;

/**
 * 船舶bean
 * @author 
 *
 */
public class Seafood {
	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 名称
	 */
	private String name ;

	/**
	 * 编号
	 */
	private String no;
	
	/**
	 *种类
	 */
	private String category;
	
	/**
	 * 数量
	 */
	private int count;
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 状态（在库、出库）
	 */
	private String status;
	
	
	private Date intime;
	
	
	private Date outtime;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getIntime() {
		return intime;
	}


	public void setIntime(Date intime) {
		this.intime = intime;
	}


	public Date getOuttime() {
		return outtime;
	}


	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}


}
