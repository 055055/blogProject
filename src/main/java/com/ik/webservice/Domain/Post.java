package com.ik.webservice.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Post {
	@Id
	@GeneratedValue
	int id;
	String subject;
	
	@Column(length = 100000000)
	String content;
	
	Date regDate;
	
	
}
