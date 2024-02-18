package com.demo.service;

import java.util.List;

import com.demo.model.Admin;

public interface IAdminService {
	List<Admin> getAdmins();

	void addnewAdmin(Admin adm);

	Admin getAdminById(int adminID);

	void updateById(Admin adm);

	void deleteById(int adminId);
}
