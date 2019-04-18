package com.org.jacksonjson;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ParseStringEx1 {
	String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5  }"; //    , \"wheels\": 4, \"categories\":[\"VDI\",\"ZXI\"]
	//@Test
	public void test001() throws JsonParseException, IOException {
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(carJson);
		while(!parser.isClosed()) {
			JsonToken jsonToken = parser.nextToken();
			System.out.println("Json Token : " + jsonToken);
		}
	}
	
	@Test
	public void test002() throws JsonParseException, IOException {
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(carJson);
		
		Car car = new Car();
		
		while(!parser.isClosed()) {
			JsonToken jsonToken = parser.nextToken();
			
			if(JsonToken.FIELD_NAME.equals(jsonToken)) {

				String fieldName = parser.getCurrentName();
				System.out.println(fieldName);
				
				
					if("brand".equals(fieldName)) {
						car.brand = parser.getValueAsString();
					}else if("doors".equals(fieldName)) {
						car.doors = parser.getValueAsInt();
					}
				
			}
			
			//System.out.println("Json Token : " + jsonToken);
		}
		System.out.println("car.brand = " + car.brand);
		System.out.println("car.doors = " + car.doors);
	}
	
	
}


class Car{
	String brand;
	int doors ;
}