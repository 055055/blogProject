package com.ik.webservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ik.webservice.Dao.HelloDao;
import com.ik.webservice.Domain.Hello;

@RestController
public class HelloRestController {
	@Autowired
	public HelloDao hellodao;
	
	@RequestMapping("/aa")
	public Hello add(Hello hello) {
		Hello helloData = hellodao.save(hello);
		return helloData; 
	}
	
	@RequestMapping("/list")
	public List<Hello> list(Model model){
		List<Hello> helloList = hellodao.findAll();
		return helloList;
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "hello World";
	}
}
