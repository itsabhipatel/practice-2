package com.infosys.infytel.calldetails.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.infosys.infytel.calldetails.dto.CallDetailsDTO;
import com.infosys.infytel.calldetails.entity.CallDetails;

public class CallDetailsRepositoryImpl implements CallDetailsRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CallDetails> getAllCallDetails() {
	StoredProcedureQuery sp= em.createNamedStoredProcedureQuery("getAll");
	return sp.getResultList();
	
	
	}

	@Override
	public CallDetails getAllCallDetailsById(int id) {
		StoredProcedureQuery sp= em.createNamedStoredProcedureQuery("getAllById");
		sp.setParameter("i", id);
		return (CallDetails) sp.getSingleResult();
	}

	@Override
	public int getCount() {
		StoredProcedureQuery sp=em.createNamedStoredProcedureQuery("getCount");
		int a=(int) sp.getOutputParameterValue("i");
		
		return a;
	}

	@Override
	public List<ArrayList<CallDetails>> getTwoSelect() {
		StoredProcedureQuery sp=em.createNamedStoredProcedureQuery("getTwoSelect");
		List<ArrayList<CallDetails>> cll=new ArrayList<ArrayList<CallDetails>>();
		cll.add((ArrayList<CallDetails>) sp.getResultList());
		sp.hasMoreResults();
		cll.add((ArrayList<CallDetails>) sp.getResultList());
		return cll;
		
	}

	@Override
	public List<Long> getOneColumn() {
		StoredProcedureQuery sp=em.createNamedStoredProcedureQuery("getOneColumn");
		return  sp.getResultList();
	}

	@Override
	public List<CallDetailsDTO> getTwoColumn() {
		StoredProcedureQuery sp=em.createNamedStoredProcedureQuery("getTwoColumn");
		return sp.getResultList();
	}

	@Override
	public int getSelectCount() {
		return (int) em.createNamedStoredProcedureQuery("getSelectCount").getSingleResult();
		
	}

	@Override
	public Long getInOut(Long id) {
	StoredProcedureQuery sp=em.createNamedStoredProcedureQuery("getInOut");
	sp.setParameter("count",id);
	Long c=(Long) sp.getOutputParameterValue("count");
	return c;
		
	}

	@Override
	public List<ArrayList<Object>> getDiffSelect() {
		StoredProcedureQuery sp=em.createNamedStoredProcedureQuery("getDiffSelect");
		List<ArrayList<Object>> cll=new ArrayList<ArrayList<Object>>();
		System.out.println("0");
		cll.add( (ArrayList<Object>) sp.getResultList());
		System.out.println("1");
		sp.hasMoreResults();
		cll.add((ArrayList<Object>) sp.getResultList());
		System.out.println("2");
		return cll;
	}

	@Override
	public List<ArrayList<Object>> getDiffSelectTwo() {
		StoredProcedureQuery sp=em.createNamedStoredProcedureQuery("getDiffSelectTwo");
		List<ArrayList<Object>> cll=new ArrayList<ArrayList<Object>>();
		System.out.println("0");
		cll.add( (ArrayList<Object>) sp.getResultList());
		System.out.println("1");
		sp.hasMoreResults();
		cll.add((ArrayList<Object>) sp.getResultList());
		System.out.println("2");
		return cll;
		
	}

	
	
	
}
