package com.org.jacksonjson;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJavaObject {

	@Test
	void test001() throws JsonParseException, JsonMappingException, IOException {
		String json = "{ \"color\" : \"Red\", \"type\" : \"Triumph\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		Bike bike = objectMapper.readValue(json, Bike.class);
		System.out.println("Done");
		System.out.println("Bike Color: "+bike.getColor());
		System.out.println("Bike Type: "+bike.getType());
		
	}
}

class Bike {
	private String color;
	private String type;
	
	/*public Bike(String color, String type) {
		this.color = color;
		this.type = type;
	}*/
	
	// standard getters setters
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}