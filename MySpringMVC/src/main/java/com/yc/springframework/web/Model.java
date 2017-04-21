package com.yc.springframework.web;

import java.util.HashMap;
import java.util.Map;

public class Model {
	private Map<String,String> parameterMap=new HashMap<String,String>();

	public Map<String, String> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String> parameterMap) {
		this.parameterMap = parameterMap;
	}
	
}
