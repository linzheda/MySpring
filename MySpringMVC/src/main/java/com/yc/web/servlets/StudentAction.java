package com.yc.web.servlets;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;
import com.yc.springframework.web.Action;
import com.yc.springframework.web.Model;
import com.yc.springframework.web.ModelAndView;
import com.yc.springframework.web.Validator;



@Component(value="student")
@Scope(value="prototype")
public class StudentAction implements Action{

	private StudentBiz studentBiz;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String op=request.getParameter("op");

		if(op.equals("add")){
			String sname = request.getParameter("sname");
			System.out.println("添加了:" + sname);

			Student student = new Student();
			student.setSname(sname);

			student = studentBiz.add(student);

			request.getSession().setAttribute("student", student);


			return "show.jsp";
		}

		return null;
	}
	@Override
	public ModelAndView handleRequest(Model model) {
		String op=model.getParameterMap().get("op");

		if(op.equals("add")){
			String sname = model.getParameterMap().get("sname");
			System.out.println("添加了:" + sname);

			Student student = new Student();
			student.setSname(sname);

			Validator validator=new StudentValidator();
			List<String> errors=validator.validate(student);
			ModelAndView mv=new ModelAndView();
			if(errors.isEmpty()){
				student = studentBiz.add(student);
				mv.setDirect(false);
				mv.setModel(student);
				mv.setModelName("student");
				mv.setUrl("show.jsp");
				mv.setWebScope(ModelAndView.WEBSCOPE_SESSION);
			}else{
				mv.setDirect(false);
				mv.setModel(errors);
				mv.setModelName("errors");
				mv.setUrl("index.jsp");
				mv.setWebScope(ModelAndView.WEBSCOPE_REQUEST);
			}
			return mv;
		}

		return null;
	}





	@Resource(name="studentBizImpl")
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}



}
