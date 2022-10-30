package com.example.appengineers.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appengineers.instagramclone.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {
//	List<User> findByGender();

}
