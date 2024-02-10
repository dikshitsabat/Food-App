package com.jsp.foodapp.controller;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.AdminDao;
import com.jsp.foodapp.entites.Admin;

@Controller
public class AdminController {
	
	@Autowired
	AdminDao adminDao;
	
	@RequestMapping("/addadmin")
	public ModelAndView addAdmin() {
		ModelAndView mav = new ModelAndView("Createadmin");
		Admin admin = new Admin();
		mav.addObject("command",admin);
		return mav;
	}
	
	@RequestMapping("/saveadmin")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admin a) {
		ModelAndView mav = new ModelAndView("loginadmin");
		adminDao.saveAdmin(a);
		return mav; 
		
	}
	
	@RequestMapping("/validateadmin")
	public ModelAndView loginValidation(ServletRequest req) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Admin admin = adminDao.login(email, password);
		if(admin==null) {
			ModelAndView mav = new ModelAndView("loginadmin");
			mav.addObject("message", "invalid credentials");
			return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("adminoptions");
			mav.addObject("message","login done");
			return mav;
		}
	}
}
	
	
	
	
	
//	@RequestMapping("/saveAdmin")
//	public ModelAndView saveAdmin(ServletRequest req) {
//		String name = req.getParameter("name");
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		
//		Admin admin = new Admin();
//		admin.setName(name);
//		admin.setEmail(email);
//		admin.setPassword(password);
//		
//		adminDao.saveAdmin(admin);
//		
//		ModelAndView mav = new ModelAndView("Adminmenu");
//		return mav;
//		
//	}
//
//}
