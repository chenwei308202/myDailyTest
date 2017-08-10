package com.cw.user.service;

import com.cw.user.model.User;

public interface UserService {
	
	
	User getUserById(int id);

	boolean batchAddUser (int i);
	
	public boolean batchAddUserPerTable(int i);

}
