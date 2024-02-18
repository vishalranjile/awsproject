
package com.demo.service;

import java.util.List;
import com.demo.model.User;

public interface IUserService {

	List<User> getUsers();

	User getUserById(int userId);

	void addnewUser(User user);

	void updateUserById(User user);

	void RemoveById(int userId);
	
}