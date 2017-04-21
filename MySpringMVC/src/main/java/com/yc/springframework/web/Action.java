package com.yc.springframework.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public String  handleRequest(HttpServletRequest request, HttpServletResponse response);
	public ModelAndView handleRequest(Model model);
	
}
