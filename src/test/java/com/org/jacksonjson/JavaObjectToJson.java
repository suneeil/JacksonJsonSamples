package com.org.jacksonjson;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJson {

	@Test
	void test001() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Bus bus = new Bus("yellow", "Volvo");
		objectMapper.writeValue(new File("target/Bus.json"), bus);
	}

}


class Bus {
	private String color;
	private String type;
	
	public Bus(String color, String type) {
		this.color = color;
		this.type = type;
	}
	
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