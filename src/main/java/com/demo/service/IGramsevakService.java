package com.demo.service;

import java.util.List;

import com.demo.model.Gramsevak;

public interface IGramsevakService {

	List<Gramsevak> getAllGs();

	Gramsevak getGsById(int gsId);

	void addnewGs(Gramsevak gramsevak);

	void updateGsById(Gramsevak gramsevak);

	void deleteGsById(int gsId);

}
