package com.yc.springframework.web;

public class ModelAndView {
	public static final String WEBSCOPE_REQUEST="request";
	public static final String WEBSCOPE_SESSION="session";
	public static final String WEBSCOPE_APPLICATION="application";
	
	private String url;
	private boolean isDirect;
	private Object model;
	private String webScope;
	private String modelName;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isDirect() {
		return isDirect;
	}
	public void setDirect(boolean isDirect) {
		this.isDirect = isDirect;
	}
	public Object getModel() {
		return model;
	}
	public void setModel(Object model) {
		this.model = model;
	}
	public String getWebScope() {
		return webScope;
	}
	public void setWebScope(String webScope) {
		this.webScope = webScope;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	@Override
	public String toString() {
		return "ModelAndView [WEBSCOPE_REQUEST=" + WEBSCOPE_REQUEST + ", WEBSCOPE_SESSION=" + WEBSCOPE_SESSION
				+ ", WEBSCOPE_APPLICATION=" + WEBSCOPE_APPLICATION + ", url=" + url + ", isDirect=" + isDirect
				+ ", model=" + model + ", webScope=" + webScope + ", modelName=" + modelName + "]";
	}
	
	
	
}
