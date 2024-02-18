package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IComplaintDao;
import com.demo.model.Complaint;

@Service
public class ComplaintService implements IComplaintService{

	@Autowired
	private IComplaintDao complaintDao;
	
	//Get all complaint
	@Override
	public List<Complaint> getAllComplaints() {
		return complaintDao.findAll();
	}

	//Get Complaint by id
	@Override
	public Complaint getComplaintById(int id) {
		Optional<Complaint> complaint =  complaintDao.findById(id);
		if(complaint!=null)
			return complaint.get();
		return null;
	}

	//Add Complaint
	@Override
	public void addNewComplaint(Complaint comp) {
		complaintDao.save(comp);		
	}

	//Update Complaint
	@Override
	public void updateComplaint(Complaint comp) {
		Optional<Complaint> complaint =  complaintDao.findById(comp.getComplaintId());
		if(complaint.isPresent()) {
			Complaint cmt = complaint.get();
			cmt.setCategory(comp.getCategory());
			cmt.setDescription(comp.getDescription());
			cmt.setDistrict(comp.getDistrict());
			cmt.setTaluka(comp.getTaluka());
			cmt.setVillage(comp.getVillage());
			complaintDao.save(cmt);
		}
	}

	@Override
	public void deleteComplaint(int id) {
		complaintDao.deleteById(id);
	}

	
	
	// WHERE SELECT * FROM tbl_complaint WHERE status = 'new'
	@Override
	public List<Complaint> getNewComplaints() {
		return complaintDao.getNewCompaints("new");
	}
	

	
	// WHERE SELECT * FROM tbl_complaint WHERE status = 'inprocess'
	@Override
	public List<Complaint> getInProcessComplaints() {
		return complaintDao.getInProcessCompaints("inprocess");
	}
	
	
	// WHERE SELECT * FROM tbl_complaint WHERE status = 'completed'
	@Override
	public List<Complaint> getCompletedComplaints() {
		return complaintDao.getCompletedCompaints("completed");
	}
	

	@Override
	public void editNewStatus(Complaint cmp) {
		Optional<Complaint> complaint =  complaintDao.findById(cmp.getComplaintId());
		if(complaint.isPresent()) {
			Complaint cmt = complaint.get();
			cmt.setStatus("inprocess");
			complaintDao.save(cmt);
		}
	}

	@Override
	public void editInProcessStatus(Complaint cmp) {
		Optional<Complaint> complaint =  complaintDao.findById(cmp.getComplaintId());
		if(complaint.isPresent()) {
			Complaint cmt = complaint.get();
			cmt.setStatus("completed");
			complaintDao.save(cmt);
		}
	}

	// WHERE SELECT * FROM tbl_complaint WHERE village = 'village'
	@Override
	public List<Complaint> getVillageComplaints(String village) {
		return complaintDao.findByVillage(village);
	}
	

}
