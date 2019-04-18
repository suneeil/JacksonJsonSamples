package com.org.jacksonjson;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;


public class UnmarshillingEx1 {

	@Test
	void unknownFields() throws JsonParseException, JsonMappingException, IOException {
		String jsonAsString = "{\"stringValue\":\"a\",\"intVale\":1,\"booleanValue\":true,\"stringValue2\":\"b\"}";
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MyDto dto = objectMapper.readValue(jsonAsString, MyDto.class);
		Assert.assertNotNull(dto);
		
		
	}

	
}

class MyDto{
	private int intValue;
	private String stringValue;
	private boolean booleanValue;
}