package com.infosys.infytel.calldetails.repository;

import java.util.ArrayList;
import java.util.List;

import com.infosys.infytel.calldetails.dto.CallDetailsDTO;
import com.infosys.infytel.calldetails.entity.CallDetails;

public interface CallDetailsRepositoryCustom {
public List<CallDetails> getAllCallDetails();
public CallDetails getAllCallDetailsById(int id);
public int getCount();
public List<ArrayList<CallDetails>> getTwoSelect();
public List<Long> getOneColumn();
public List<CallDetailsDTO> getTwoColumn();
public int getSelectCount();
public Long getInOut(Long id);
public List<ArrayList<Object>> getDiffSelect();
public List<ArrayList<Object>> getDiffSelectTwo();
}
