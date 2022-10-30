package com.example.appengineers.instagramclone.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FollowingUser {
	@Id
	private Integer id;
	private String name;
	private String gender;
	@ManyToOne(fetch=FetchType.LAZY) @JsonIgnore
	private MyUser user;
	
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
	public MyUser getUser() {
		return user;
	}
	public void setUser(MyUser user) {
		this.user = user;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public FollowingUser(Integer id, String name, String gender, MyUser user) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.user = user;
	}
	public FollowingUser() {
	}
	

}
