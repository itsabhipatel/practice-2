package com.infosys.infytel.calldetails.dto;

public class CallDetailsDTO {

	long id;

	int duration;

	public CallDetailsDTO(long id, int duration) {
		super();
		this.id = id;
		this.duration = duration;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
}
