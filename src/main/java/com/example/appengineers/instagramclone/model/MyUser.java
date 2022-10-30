package com.example.appengineers.instagramclone.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MyUser {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String gender;
	@OneToMany(mappedBy="user")
	private List<FollowingUser> followingUsers;
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	public Integer getId() {
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
	public List<FollowingUser> getFollowingUsers() {
		return followingUsers;
	}
	public void setFollowingUsers(List<FollowingUser> followingUsers) {
		this.followingUsers = followingUsers;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
