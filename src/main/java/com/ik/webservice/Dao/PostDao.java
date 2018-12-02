package com.ik.webservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ik.webservice.Domain.Post;

public interface PostDao extends JpaRepository<Post, Integer>{

}
