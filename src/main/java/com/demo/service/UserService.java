package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IUserDao;
import com.demo.model.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao udao;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return udao.findAll();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<User> op=udao.findById(userId);
		if(op.isPresent()) {
			 return op.get();
		 }
		 
		return null;
	}

	@Override
	public void addnewUser(User user) {
		udao.save(user);
		
	}

	@Override
	public void updateUserById(User adm) {
		// TODO Auto-generated method stub
		Optional<User> user=udao.findById(adm.getUserId());
		if(user.isPresent()) {
			User a=user.get();
			a.setFirstName(adm.getFirstName());
			a.setLastName(adm.getLastName());
			a.setUsername(adm.getUsername());
			a.setPhoneNumber(adm.getPhoneNumber());
			a.setEmailId(adm.getEmailId());
			udao.save(a);
		}
		
	}

	@Override
	public void RemoveById(int userId) {
		udao.deleteById(userId);
		}
		
	}

	
	
	
	


