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

import com.demo.model.Complaint;
import com.demo.service.IComplaintService;

@CrossOrigin
@RestController
public class ComplaintController {
    @Autowired
    private IComplaintService complaintService;

    
    // error was due to ambigues in put mapping in update by id and update status.
    //Get all complaints
    @GetMapping("/complaints") 
    public ResponseEntity<List<Complaint>> getAllComplaints(){
        List<Complaint> compList = complaintService.getAllComplaints();
        return ResponseEntity.ok(compList);
    }
    
    //Get Complaint by id
    @GetMapping("/complaints/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable int id){
        Complaint complaint = complaintService.getComplaintById(id);
        if(complaint != null)
            return ResponseEntity.ok(complaint);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    //Add new complaint
    @PostMapping("/complaints")
    public ResponseEntity<String> addNewComplaint(@RequestBody Complaint comp){
        complaintService.addNewComplaint(comp);
        return ResponseEntity.ok("Complaint Added Successfully");
    }
    



    
	@PutMapping("/complaint/{id}")
	public ResponseEntity<String> updateAdmin(@RequestBody Complaint comp){
		complaintService.updateComplaint(comp);
		return ResponseEntity.ok("data updated successfully");
	}
    
    //Delete a complaint
    @DeleteMapping("/complaints/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable int id){
        complaintService.deleteComplaint(id);
        return ResponseEntity.ok("Complaint Deleted Successfully");
    }
    
    //Get complaints based on status -> new / in-process / completed
    @GetMapping("/complaints/status/{status}")
    public ResponseEntity<List<Complaint>> getComplaintStatus(@PathVariable String status){
        List<Complaint> compList = null;
        if(status != null && !status.isEmpty()) {
            if(status.equalsIgnoreCase("completed"))
                compList = complaintService.getCompletedComplaints();
            else if(status.equalsIgnoreCase("inprocess")) 
                compList = complaintService.getInProcessComplaints();
            else 
                compList = complaintService.getNewComplaints();
            return ResponseEntity.ok(compList);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    
    //Edit complaint status -> [new to in-process] / [in-process to completed]
    //it is not working
    @PutMapping("/complaints/{status}")
	public ResponseEntity<String> editComplaintStatus(@RequestBody Complaint cmp){
		if(cmp!=null) {
			if(cmp.getStatus().equalsIgnoreCase("new"))
				complaintService.editNewStatus(cmp);
			else  
				complaintService.editInProcessStatus(cmp);
			return ResponseEntity.ok("Status Updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
	}
    
    //Get complaints village wise
    @GetMapping("/complaints/village/{village}")
    public ResponseEntity<List<Complaint>> getVillageComplaints(@PathVariable String village){
        List<Complaint> compList = complaintService.getVillageComplaints(village);
        if(compList != null && !compList.isEmpty())
            return ResponseEntity.ok(compList);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

