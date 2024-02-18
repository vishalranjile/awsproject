package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Gramsevak;
import com.demo.service.IGramsevakService;


@CrossOrigin
@RestController
public class GramsevakController {
	
	@Autowired
	private IGramsevakService gservice;
	
	@GetMapping("/gramsevaks")
	public ResponseEntity<List<Gramsevak>> getallGramsevakss(){
		List<Gramsevak> gslist=gservice.getAllGs();
		return ResponseEntity.ok(gslist);
		
	}
	
	@GetMapping("/gramsevaks/{gsId}")
	public ResponseEntity<Gramsevak> getGsById(@PathVariable int gsId){
		Gramsevak gs=gservice.getGsById(gsId);
		if (gs!=null)
			return ResponseEntity.ok(gs);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("gramsevaks/{gsId}")
	public ResponseEntity<String> insertGramsevak(@RequestBody Gramsevak gramsevak){
		gservice.addnewGs(gramsevak);
		return ResponseEntity.ok("data added successfully");
		
	}
	@PutMapping("gramsevaks/{gsId}")
	public ResponseEntity<String> updateAdmin(@RequestBody Gramsevak gramsevak){
		gservice.updateGsById(gramsevak);
		return ResponseEntity.ok("data updated successfully");
		
	}
	@DeleteMapping("/gramsevaks/{gsId}")
	public ResponseEntity<String> removeById(@PathVariable int gsId){
		gservice.deleteGsById(gsId);
		return ResponseEntity.ok("data deleted successfully");
		
	}

}
