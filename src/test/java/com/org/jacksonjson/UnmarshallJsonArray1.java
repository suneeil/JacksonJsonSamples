package com.org.jacksonjson;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnmarshallJsonArray1 {

	@Test
	void test001() throws JsonParseException, JsonMappingException, IOException {
		String jsonBookArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		ObjectMapper objectMapper = new ObjectMapper();
		List<Book> listOfBooks = objectMapper.readValue(jsonBookArray, new TypeReference<List<Book>>() {});
		System.out.println(listOfBooks.size());
		System.out.println(listOfBooks.get(0).getType());
		System.out.println(listOfBooks.get(1).getType());
		listOfBooks.stream().forEach(System.out::println);
	}
	
	@Test
	void test002() {
		
	}
	
	
}




class Book{
	String color;
	String type;
	
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
	
	public Book() {
		
	}
	
	public Book(String color, String type) {
		this.color = color;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "{\"color\":"+color
				+ ",\"type\":"+type
				+"}";
	}
}