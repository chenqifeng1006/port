package com.cc.admin.dto;


public class Port {
	private int id;
	
	private int parkingCount ;

	private int used;
	
	private int remained;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getParkingCount() {
		return parkingCount;
	}

	public void setParkingCount(int parkingCount) {
		this.parkingCount = parkingCount;
	}

	public int getUsed() {
		return used;
	}

	public void setUsed(int used) {
		this.used = used;
	}

	public int getRemained() {
		return remained;
	}

	public void setRemained(int remained) {
		this.remained = remained;
	}


}
