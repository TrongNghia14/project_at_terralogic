package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rookie_employee")
public class RookieEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rookie_id")
	private long id;

	@Column(name = "rookie_name")
	private String rookieName;

	@Column(name = "position")
	private String position;

	@Column(name = "location")
	private String location;

	@Column(name = "date_of_joining")
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
