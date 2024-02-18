package com.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.model.Complaint;

@Repository
public interface IComplaintDao extends JpaRepository<Complaint,Integer>{

	// WHERE SELECT * FROM tbl_complaint WHERE village = 'village'
	@Query("SELECT c FROM Complaint c WHERE c.village = :village")
	 List<Complaint> findByVillage(@Param("village") String village);
	
	//WHERE SELECT * FROM tbl_complaint WHERE status = 'completed'
	@Query("SELECT c FROM Complaint c WHERE c.status = :status")
	 List<Complaint> getCompletedCompaints(@Param("status") String status);
	
	//WHERE SELECT * FROM tbl_complaint WHERE status = 'inprocess'
	@Query("SELECT c FROM Complaint c WHERE c.status = :status")
	 List<Complaint> getInProcessCompaints(@Param("status") String status);
	
	//WHERE SELECT * FROM tbl_complaint WHERE status = 'new'
	@Query("SELECT c FROM Complaint c WHERE c.status = :status")
	 List<Complaint> getNewCompaints(@Param("status") String status);
}
