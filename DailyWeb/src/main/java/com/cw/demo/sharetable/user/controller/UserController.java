package com.cw.demo.sharetable.user.controller;

import com.cw.demo.sharetable.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping("/niuBiXiaoHui")
	public void insert(HttpServletRequest request,HttpServletResponse response,String  where) throws Exception {
        response.setCharacterEncoding("utf-8");

		System.out.println("地里位置：——————"+where);



	}

	
}
