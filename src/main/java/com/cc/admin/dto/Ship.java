package com.cc.admin.dto;

/**
 * 船舶bean
 * @author 
 *
 */
public class Ship {
	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 船名
	 */
	private String name ;

	/**
	 * 核载数量
	 */
	private String hezai;
	
	/**
	 * 船舶类型（货船、客船）
	 */
	private String type;
	
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 状态（在港、离岗）
	 */
	private String status;

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

	public String getHezai() {
		return hezai;
	}

	public void setHezai(String hezai) {
		this.hezai = hezai;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	
}
