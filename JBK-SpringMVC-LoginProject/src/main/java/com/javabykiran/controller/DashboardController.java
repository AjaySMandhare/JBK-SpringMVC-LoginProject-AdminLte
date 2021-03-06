package com.javabykiran.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Users;
import com.javabykiran.model.downloads_list;
import com.javabykiran.service.User_Service;

@Controller
public class DashboardController {

	@Autowired
	private User_Service userService;
	
	@RequestMapping(value="/userspage")
	public ModelAndView userspage( Model model)
	{
		List<Users>users=userService.userList();
		System.out.println(users+"*********************");
		
		return new ModelAndView("users","userList",users);
	}
	
	@RequestMapping(value="/dashboard")
	public ModelAndView dashboard()
	{
		return new ModelAndView("dashboard");
	}
	
	
	@RequestMapping(value="/operators")
	public ModelAndView operatorspage()
	{
		return new ModelAndView("operators");
	}
	
	@RequestMapping(value="/downloads")
	public ModelAndView downloadpage()
	{
		ModelAndView mv = new ModelAndView();
		if(userService.showDownloadlist()!=null) {
			List<downloads_list> l = (List<downloads_list>) userService.showDownloadlist();
			mv.setViewName("downloads");
			mv.addObject("data", userService.showDownloadlist());
		}else {
			mv.addObject("msg", "List not available");
			mv.setViewName("downloads");
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/links")
	public ModelAndView linkspage()
	{
		return new ModelAndView("links");
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logoutpage(HttpServletRequest  request,HttpSession session)
	{
		session.invalidate();
		return new ModelAndView("logout");
	}
	
}
