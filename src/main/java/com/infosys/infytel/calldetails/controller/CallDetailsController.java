package com.infosys.infytel.calldetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.calldetails.dto.CallDetailsDTO;
import com.infosys.infytel.calldetails.entity.CallDetails;
import com.infosys.infytel.calldetails.entity.Employee;
import com.infosys.infytel.calldetails.repository.CallDetailsRepository;
import com.infosys.infytel.calldetails.service.CallDetailsService;

@RestController
@CrossOrigin
public class CallDetailsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CallDetailsService callDetailsService;
	
	@Autowired
	CallDetailsRepository callDetailsRepository;

	// Fetches call details of a specific customer
//	@RequestMapping(value = "/customers/{phoneNo}/calldetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo) {
//
//		logger.info("Calldetails request for customer {}", phoneNo);
//
//		return callDetailsService.getCustomerCallDetails(phoneNo);
//	}
	@RequestMapping(value="/sp",method=RequestMethod.GET,
			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
			,produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public CallDetails getCallDetails(@RequestParam(value="id") int id)
	{
		return callDetailsRepository.getCallDetails(id);
	}
	
//	@RequestMapping(value="/sp2",method=RequestMethod.GET)
//	public List<CallDetails> getCallDetails2()
//	{
//		return callDetailsRepository.getCallDetails2();
//	}
	
	
	
	
	
	
	
	@RequestMapping(value="/sp3",method=RequestMethod.GET)
	public List<CallDetails> getCallDetails3()
	{
		return callDetailsRepository.getAllCallDetails();
	}
	

	@RequestMapping(value="/sp4",method=RequestMethod.GET)
	public CallDetails getCallDetails4(@RequestParam(value="id") int id)
	{
		CallDetails cd;
		System.out.println("hello");
		cd=callDetailsRepository.getAllCallDetailsById(id);
		int a=10;
		return cd;
	}
	
	@RequestMapping(value="/sp5",method=RequestMethod.GET)
	public int getCallDetails5()
	{
		return callDetailsRepository.getCount();
	}
	
	@RequestMapping(value="/sp6",method=RequestMethod.GET)
	public List<ArrayList<CallDetails>> getCallDetails6()
	{
		return callDetailsRepository.getTwoSelect();
	}
	
	@RequestMapping(value="/sp7",method=RequestMethod.GET)
	public List<Long> getCallDetails7()
	{
		return callDetailsRepository.getOneColumn();
	}
	
	@RequestMapping(value="/sp8",method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CallDetailsDTO> getCallDetails8()
	{
		return callDetailsRepository.getTwoColumn();
	}
	
	
	@RequestMapping(value="/sp9",method=RequestMethod.GET)
	public int getCallDetails9()
	{
		return callDetailsRepository.getSelectCount();
	}
	
	@RequestMapping(value="/sp10",method=RequestMethod.GET)
	public Long getCallDetails10(@RequestParam(value="id") Long id)
	{
		return callDetailsRepository.getInOut(id);
	}
	
	@RequestMapping(value="/sp11",method=RequestMethod.GET)
	public List<ArrayList<Object>> getCallDetails11()
	{
		return callDetailsRepository.getDiffSelect();
	}
	
	@RequestMapping(value="/sp12",method=RequestMethod.GET)
	public List<ArrayList<Object>> getCallDetails12()
	{
		return callDetailsRepository.getDiffSelectTwo();
	}
	
	//QueryParam,PathParam,RequestParam are all similar
	
	@RequestMapping(value="/sp13/{num}",method=RequestMethod.GET)
	public Employee getCallDetails13(Employee e)
	{
		return e;
	}
	
	@RequestMapping(value="/sp14",method=RequestMethod.GET)
	public Employee getCallDetails14(@RequestBody Employee e)
	{
		return e;
	}
	@RequestMapping(value="/sp15",method=RequestMethod.GET)
	public void getCallDetails15()
	{
		Employee e=null;
		System.out.println(e.getName());
	}
	@RequestMapping(value="/sp16",method=RequestMethod.GET)
	public  String getCallDetails1()
	{

		return "Call Successfully  done";
	}
	
	
}

