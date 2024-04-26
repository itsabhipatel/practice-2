package com.infosys.infytel.calldetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.infosys.infytel.calldetails.entity.CallDetails;

public interface CallDetailsRepository extends JpaRepository<CallDetails, Long>,CallDetailsRepositoryCustom {

	List<CallDetails> findByCalledBy(long calledBy);
	
	@Query(value="select * from tb where no=?1",nativeQuery = true)
	CallDetails getCallDetails(int idno);
	
//	@Procedure(value="spGetAll")
//	List<CallDetails> getCallDetails2();
}
