package com.cw.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cw.demo.fenbiao.user.model.User;
import com.cw.demo.fenbiao.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void test1(){
		
	User user=	userService.getUserById(1);
	System.out.println(user);
		
	}
	
}
