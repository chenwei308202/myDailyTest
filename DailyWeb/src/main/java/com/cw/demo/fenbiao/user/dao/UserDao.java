package com.cw.demo.fenbiao.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cw.demo.fenbiao.user.model.User;
import com.cw.demo.fenbiao.user.model.UserInfo;

@Repository
public interface UserDao {

	User selectOne(int id);

	void batchInsert( List<User> users);
	
	void batchInsertPerTable(UserInfo user);
}
