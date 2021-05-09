package com.example.demo.dto;

import java.util.Date;

public class RookieEmployeeDto {
	private long id;
	private String rookieName;
	private String position;
	private String location;
	private Date dateJoin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRookieName() {
		return rookieName;
	}

	public void setRookieName(String rookieName) {
		this.rookieName = rookieName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

}
