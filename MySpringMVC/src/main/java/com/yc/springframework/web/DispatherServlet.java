package com.yc.springframework.web;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DispatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.解析uri请求地址
		String uri=request.getRequestURI();
		
		//2.取出student.action
		String actionName=uri.substring(uri.lastIndexOf("/")+1);
		actionName=actionName.substring(0, actionName.lastIndexOf("."));
		//3.判断是否为studet如果是则实例化studentAction
		Action action=null;
		//托管给spring
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		action=(Action)ac.getBean(actionName);
		//4.调用action中的handlerequest
		//5.获取还返回值
		ModelAndView mv=null;
		if(action!=null){
			Model model =new Model();
			Map<String,String[]> map=request.getParameterMap();
			for(Entry<String, String[]> entry:map.entrySet()){
				model.getParameterMap().put(entry.getKey(), entry.getValue()[0]);
			}
			
			mv=action.handleRequest(model);
		}
		//6.根据返回值，跳转页面
		
		if(mv==null){
			request.getRequestDispatcher("404.jsp").forward(request, response);
			
		}else{
			if(mv.getModel()!=null){
				Object obj=mv.getModel();
				switch(mv.getWebScope()){
				case ModelAndView.WEBSCOPE_REQUEST:
					request.setAttribute(mv.getModelName(), obj);
					break;
				case ModelAndView.WEBSCOPE_SESSION:
					request.setAttribute(mv.getModelName(), obj);
					break;
				case ModelAndView.WEBSCOPE_APPLICATION:
					request.getServletContext().setAttribute(mv.getModelName(), obj);
					break;
				}
				
			}
		}
		
		if(mv.getUrl()!=null){
			if(mv.isDirect()){
				response.sendRedirect(mv.getUrl());
			}else{
				request.getRequestDispatcher(mv.getUrl()).forward(request, response);
			}
		}
		
		
	
	}

}
