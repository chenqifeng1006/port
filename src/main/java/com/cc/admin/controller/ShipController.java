package com.cc.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.Ship;
import com.cc.admin.service.ShipService;
import com.cc.base.BaseController;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;



@Controller
@RequestMapping("ship")
public class ShipController extends BaseController {
	

	@Autowired
	private ShipService shipService;
	

	@RequestMapping(value = "/queryPage", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject queryPage(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
	
			List<Ship> list = this.shipService.queryPage(startNum,pageCount);		
			int count = this.shipService.count();
			int currentPage = startNum/pageCount + 1;
			PageDTO dto = new PageDTO();		
			dto.setList(list);
			dto.setCount(count);
			dto.setStartNum(startNum);
			dto.setCurrentPage(currentPage);
			dto.setPageCount(pageCount);			
			return new JsonData(dto);
		
	}
	
	
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonSuccess delete( Ship ship) throws Exception {
		
		this.shipService.delete(ship.getId());
		
		return new JsonSuccess("删除成功");
	}
	
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonSuccess update( Ship ship) throws Exception {

		
		this.shipService.update(ship);
		
		return new JsonSuccess("修改成功");
	}
	
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public JsonSuccess insert( Ship ship) throws Exception {

		
		this.shipService.insert(ship);
		
		return new JsonSuccess("创建成功");
	}
	
	@RequestMapping(value = "/setLeave")
	@ResponseBody
	public JsonSuccess setLeave( Ship ship) throws Exception {

		ship.setStatus("离港");
		this.shipService.updateStatus(ship);
		
		return new JsonSuccess("设置成功");
	}
	
	
	@RequestMapping(value = "/setBack")
	@ResponseBody
	public JsonSuccess setBack( Ship ship) throws Exception {

		ship.setStatus("在港");
		this.shipService.updateStatus(ship);
		
		
		return new JsonSuccess("设置成功");
	}
	
}