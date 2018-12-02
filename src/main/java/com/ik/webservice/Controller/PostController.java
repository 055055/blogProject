package com.ik.webservice.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ik.webservice.Dao.PostDao;
import com.ik.webservice.Domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostDao postdao;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String form(Post post) {
		return "form";
	}
	
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute Post post) {
		log.debug("####"+post.getSubject());
		log.debug("@@@@"+post.getContent());
		post.setRegDate(new Date());
		return "redirect:/post/"+postdao.save(post).getId();
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.debug("실행이닷");
		List<Post> postDate = postdao.findAll();
		model.addAttribute("postList", postDate);
		log.debug("postList"+postDate);
		log.debug("실행");
		return "blog";
	}
	
	@RequestMapping("/{id}")
	public String view(Model model, @PathVariable int id) throws Exception {
		Optional<Post> post = postdao.findById(id);
		System.out.println(post);
		if(post.isPresent()) {
			model.addAttribute("post", post.get());
		}else {
			throw new Exception("화면이 없습니다.");	
		}
		System.out.println("post"+post);
		return "post";
	}
}
