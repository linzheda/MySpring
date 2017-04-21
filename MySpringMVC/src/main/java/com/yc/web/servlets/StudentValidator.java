package com.yc.web.servlets;

import java.util.ArrayList;
import java.util.List;

import com.yc.bean.Student;
import com.yc.springframework.web.Validator;

public class StudentValidator implements Validator{

	@Override
	public List<String> validate(Object obj) {
		List<String> errors=new ArrayList<String>();
		if(obj==null){
			errors.add("学生不能为空");
		}
		
		if(!(obj instanceof Student)){
			errors.add("请输入学生对象信息");
			
		}
		Student s=(Student) obj;
		if(s.getSname()==null||"".equals(s.getSname())){
			errors.add("学生名不能为空");
		}
		
		return errors;
	}

}
