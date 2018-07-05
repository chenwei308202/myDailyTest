package com.cw.demo.sharetable.user.dao;

import com.cw.demo.sharetable.user.model.User;
import com.cw.demo.sharetable.user.model.UserInfo;

import java.util.List;

//@Repository
public interface UserDao {

	User selectOne(int id);

	void batchInsert( List<User> users);
	
	void batchInsertPerTable(UserInfo user);


}
