package com.yc.dao.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.yc.bean.Student;
import com.yc.dao.StudentDao;

//交给spring托管
@Repository
public class StudentDaoImpl implements StudentDao {

	@Override
	public Student add(Student student) {
		AtomicLong generator=new AtomicLong();
		Long sid=generator.incrementAndGet();
		
		student.setSid(sid);
		
		
		return student;
	}

}
