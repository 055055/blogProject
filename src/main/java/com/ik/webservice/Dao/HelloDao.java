package com.ik.webservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ik.webservice.Domain.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer> {

}
