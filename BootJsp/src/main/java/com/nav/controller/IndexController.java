package com.nav.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nav.repository.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	UserRepository userRepo;
	
    @GetMapping("/login")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        
        return "login";
    }
     
    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page !!");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("Result ::"+userRepo.findAll());
        return "next";
    }
    
    @RequestMapping("/editor")
    public String editor(Map<String, Object> model) {
        model.put("message", "You are in new page !!");
        return "editor";
    }

}
