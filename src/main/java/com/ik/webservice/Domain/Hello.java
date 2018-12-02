package com.ik.webservice.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Hello {
	@Id
	@GeneratedValue
	int id;
	String name;
}
