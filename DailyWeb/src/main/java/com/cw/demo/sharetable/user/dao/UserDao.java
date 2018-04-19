package com.cw.demo.sharetable.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cw.demo.sharetable.user.model.User;
import com.cw.demo.sharetable.user.model.UserInfo;

@Repository
public interface UserDao {

	User selectOne(int id);

	void batchInsert( List<User> users);
	
	void batchInsertPerTable(UserInfo user);
}
