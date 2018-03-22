package com.cw.demo.fenbiao.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cw.demo.fenbiao.user.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response,Integer total){
		
		boolean flag= userService.batchAddUser(total);
		
		return "user";
	}
	
	@RequestMapping("/batchPerTable")
	public String batchPerTable(HttpServletRequest request,HttpServletResponse response,Integer total){
		
		boolean flag= userService.batchAddUserPerTable(total);
		
		return "user";
	}
	
}
