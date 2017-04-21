package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;
import com.yc.dao.BaseDao;
import com.yc.dao.StudentDao;

@Service
public class StudentBizImpl implements StudentBiz {

	//private StudentDao studentDao;
	private BaseDao baseDao;
	
	@Override
	public Student add(Student student) {
		 this.baseDao.add(student, "save");
		 return student;
	}

	@Resource(name = "baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	

}
