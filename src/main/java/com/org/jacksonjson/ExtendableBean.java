package com.org.jacksonjson;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;

public class ExtendableBean {
	public String name;
	private Map<String, String> properties;
	
	public ExtendableBean(String string) {
		// TODO Auto-generated constructor stub
	}


	@JsonGetter
	public Map<String, String> getProperties() {
        return properties;
    }

}
