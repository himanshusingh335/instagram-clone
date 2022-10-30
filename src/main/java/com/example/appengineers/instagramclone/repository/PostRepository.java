package com.example.appengineers.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appengineers.instagramclone.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
