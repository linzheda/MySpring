package com.yc.springframework.web;

import java.util.List;

public interface Validator {
	public List<String> validate(Object object);
} 
