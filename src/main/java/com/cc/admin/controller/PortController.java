package com.cc.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.Port;
import com.cc.admin.dto.Ship;
import com.cc.admin.service.PortService;
import com.cc.admin.service.ShipService;
import com.cc.base.BaseController;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;



@Controller
@RequestMapping("port")
public class PortController extends BaseController {
	

	@Autowired
	private PortService portService;
	

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject query() {
	
		
		    Port port=this.portService.query();
			return new JsonData(port);
		
	}
	
}