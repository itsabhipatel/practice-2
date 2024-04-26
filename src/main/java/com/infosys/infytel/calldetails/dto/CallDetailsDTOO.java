package com.infosys.infytel.calldetails.dto;

public class CallDetailsDTOO {
	long calledBy;
	long calledTo;
	
	public CallDetailsDTOO(long calledBy, long calledTo) {
		super();
		this.calledBy = calledBy;
		this.calledTo = calledTo;
	}

	public long getCalledBy() {
		return calledBy;
	}

	public void setCalledBy(long calledBy) {
		this.calledBy = calledBy;
	}

	public long getCalledTo() {
		return calledTo;
	}

	public void setCalledTo(long calledTo) {
		this.calledTo = calledTo;
	}
	
	
	
}
