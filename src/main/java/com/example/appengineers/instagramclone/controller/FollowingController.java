package com.example.appengineers.instagramclone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appengineers.instagramclone.model.FollowingUser;
import com.example.appengineers.instagramclone.model.MyUser;
import com.example.appengineers.instagramclone.repository.FollowingUserRepository;
import com.example.appengineers.instagramclone.repository.UserRepository;

@RestController
public class FollowingController {

	@Autowired
	UserRepository userService;
	
	@Autowired
	FollowingUserRepository followingUserService;
	
	@GetMapping("/users/{id}/following")
	public List<FollowingUser> getAllFollowing(@PathVariable Integer id){
		Optional<MyUser> user=userService.findById(id);
		return user.get().getFollowingUsers();
	}
	
	@GetMapping("/users/{id}/following/{fid}")
	public FollowingUser getFollowingById(@PathVariable Integer id, Integer fid){
		Optional<MyUser> user=userService.findById(id);
		List<FollowingUser> users=user.get().getFollowingUsers();
		FollowingUser myUser = null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId()==fid) {
				myUser=users.get(i);
			}
		}
		return myUser;
	}
	
//	@GetMapping("/users/{id}/following/{gender}")
//	public List<FollowingUser> getFollowingByGender(@PathVariable Integer id,@PathVariable String gender){
//		Optional<MyUser> user=userService.findById(id);
//		List<FollowingUser> users=user.get().getFollowingUsers();
//		List<FollowingUser> myUsers = new ArrayList<>();
//		for(int i=0;i<users.size();i++) {
//			if(users.get(i).getGender()==gender) {
//				myUsers.add(users.get(i));
//			}
//		}
//		return myUsers;
//	}
	
	@PostMapping("/users/{id}/following/{fid}")
	public void followUser(@PathVariable Integer fid, @PathVariable Integer id){
		Optional<MyUser> user=userService.findById(id);
		Optional<MyUser> fuser=userService.findById(fid);
		FollowingUser followUser=new FollowingUser(fid,fuser.get().getName(),fuser.get().getGender(),user.get());
		followingUserService.save(followUser);
		
	}
	
	@DeleteMapping("/users/{id}/following/{fid}")
	public void deleteUsersById(@PathVariable Integer id, @PathVariable Integer fid){
		followingUserService.deleteById(fid);
	}

}
