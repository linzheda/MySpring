package com.yc.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Student;
import com.yc.biz.StudentBiz;

import junit.framework.TestCase;

public class TestSpring extends TestCase {

	
	public void testSpring1() {
		// 实例化spring容器
		// ClassPathXmlApplicationContext -> 路径的容器
		// FileSystemXmlApplicationContext -> 文件路径容器 c:\
		// Annoted..... 注解的容器
		// Web.... web的容器
		Student s = new Student();
		s.setSname("张三");
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		StudentBiz sb = (StudentBiz) ac.getBean("studentBizImpl");
		s = sb.add(s);
		System.out.println(s.getSid() + "  " + s.getSname());
	}
	
	
	public void testSpring2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		DataSource sb = (DataSource) ac.getBean("dataSource");
		System.out.println(sb);
	}
	public void testSpring3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Object sb =  ac.getBean("sqlSessionFactory");
		System.out.println(sb);
	}
	
	
}
