package com.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IGramsevakDao;
import com.demo.model.Gramsevak;


@Service
public class GramsevakService implements IGramsevakService {
	
	@Autowired
	private IGramsevakDao gdao;

	@Override
	public List<Gramsevak> getAllGs() {
		// TODO Auto-generated method stub
		return gdao.findAll();
	}

	@Override
	public Gramsevak getGsById(int gsId) {
		// TODO Auto-generated method stub
		Optional<Gramsevak> op=gdao.findById(gsId);
		if(op.isPresent()) {
			 return op.get();
		 }
		 return null;
		
	}

	@Override
	public void addnewGs(Gramsevak gramsevak) {
		gdao.save(gramsevak);
		
	}

	@Override
	public void updateGsById(Gramsevak gramsevak) {
		Optional<Gramsevak> Gs=gdao.findById(gramsevak.getGsid());
		if(Gs.isPresent()) {
			Gramsevak gramsev =Gs.get();
			gramsev.setFirstName(gramsevak.getFirstName());
			gramsev.setLastName(gramsevak.getLastName());
			gramsev.setUsername(gramsevak.getUsername());
			gramsev.setPhoneNumber(gramsevak.getPhoneNumber());
			gramsev.setEmailId(gramsevak.getEmailId());
			
			gdao.save(gramsev);
		}
	}

	@Override
	public void deleteGsById(int gsId) {
		// TODO Auto-generated method stub
		gdao.deleteById(gsId);
	}



}
