package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IAdminDao;
import com.demo.model.Admin;

@Service 
public class AdminService implements IAdminService {

	@Autowired
	private IAdminDao adao;
	@Override
	public List<Admin> getAdmins() {
		return adao.findAll();
	}

	@Override
	public void addnewAdmin(Admin adm) {
		adao.save(adm);
	}

	@Override
	public Admin getAdminById(int adminID) {
		Optional<Admin> op=adao.findById(adminID);
		if(op.isPresent()) {
			 return op.get();
		 }
		 return null;	
	}

	@Override
	public void updateById(Admin adm) {
		Optional<Admin> admin=adao.findById(adm.getAdminId());
		if(admin.isPresent()) {
			Admin a=admin.get();
			a.setFirstName(adm.getFirstName());
			a.setLastName(adm.getLastName());
			a.setUsername(adm.getUsername());
			a.setPhoneNumber(adm.getPhoneNumber());
			a.setEmailId(adm.getEmailId());
			adao.save(a);
		}		
	}

	@Override
	public void deleteById(int adminId) {
		adao.deleteById(adminId);
	}

}