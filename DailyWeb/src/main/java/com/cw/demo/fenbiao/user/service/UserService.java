package com.cw.demo.fenbiao.user.service;

import com.cw.demo.fenbiao.user.model.User;

public interface UserService {
	
	
	User getUserById(int id);

	boolean batchAddUser (int i);
	
	public boolean batchAddUserPerTable(int i);

}
