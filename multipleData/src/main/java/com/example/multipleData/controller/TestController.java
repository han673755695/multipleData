package com.example.multipleData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.multipleData.entity.Menu;
import com.example.multipleData.services.IMenuService;
import com.example.multipleData.utils.UUIDUtils;

@Controller
@RequestMapping("/testController")
public class TestController {
	
	@Autowired
	private IMenuService menuService;

	@RequestMapping("/saveData")
	@ResponseBody
	public String saveData() {
		
		Menu menu = new Menu();
		menu.setId(UUIDUtils.getUUID());
		menu.setName("测试菜单");
		menuService.insert(menu);
		
		System.out.println("========");
		return "success";
	}
}
