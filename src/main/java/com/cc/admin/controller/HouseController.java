package com.cc.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.House;
import com.cc.admin.service.HouseService;
import com.cc.base.BaseController;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;



@Controller
@RequestMapping("house")
public class HouseController extends BaseController {
	

	@Autowired
	private HouseService houseService;
	

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject query() {
		House house= this.houseService.query();
		return new JsonData(house);
		
	}
	
}