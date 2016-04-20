package com.cc.admin.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.Seafood;
import com.cc.admin.service.SeafoodService;
import com.cc.base.BaseController;
import com.utils.common.PageDTO;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;



@Controller
@RequestMapping("seaFood")
public class SeafoodController extends BaseController {
	

	@Autowired
	private SeafoodService seafoodService;
	

	@RequestMapping(value = "/queryPage", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject queryPage(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
	
			List<Seafood> list = this.seafoodService.queryPage(startNum,pageCount);		
			int count = this.seafoodService.count();
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
	public JsonSuccess delete( Seafood seafood) throws Exception {
		
		this.seafoodService.delete(seafood.getId());
		
		return new JsonSuccess("删除成功");
	}

	
	
	@RequestMapping(value = "/out")
	@ResponseBody
	public JsonSuccess setOut( Seafood seafood) throws Exception {

		seafood.setStatus("out");
		seafood.setOuttime(new Date());
		this.seafoodService.updateStatus(seafood);
		
		return new JsonSuccess("设置成功");
	}
	
	
	
	
}