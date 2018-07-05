package com.cw.demo.sharetable.user.service;

import com.cw.demo.sharetable.user.model.User;

public interface UserService {
	
	
	User getUserById(int id);

	boolean batchAddUser (int i);
	
	public boolean batchAddUserPerTable(int i);

	public void addUser(String where);

}
