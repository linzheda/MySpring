package com.yc.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if (op.equals("add")) {
			add(req, resp);
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String sname = req.getParameter("sname");
		System.out.println("添加了:" + sname);

		Student student = new Student();
		student.setSname(sname);
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
		StudentBiz sb = (StudentBiz) ac.getBean("studentBizImpl");
		student = sb.add(student);

		req.getSession().setAttribute("student", student);

		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}

}
