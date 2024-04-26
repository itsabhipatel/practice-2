package com.infosys.infytel.calldetails.entity;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public class Employee {
	
private int num;
private int id;
private String name;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public Employee(int num, int id, String name) {
	super();
	this.num = num;
	this.id = id;
	this.name = name;
}

}
