package com.yc.dao;

import com.yc.bean.Student;

public interface StudentDao {
	
	/**
	 * 添加到数据库存
	 * @param student
	 * @return
	 */
	public Student add( Student student);
}
