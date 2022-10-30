package com.example.appengineers.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appengineers.instagramclone.model.FollowingUser;

@Repository
public interface FollowingUserRepository extends JpaRepository<FollowingUser, Integer> {

}
