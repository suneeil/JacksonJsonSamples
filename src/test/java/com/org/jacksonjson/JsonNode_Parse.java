package com.org.jacksonjson;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNode_Parse {

	@Test
	void test001() throws IOException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		String color = jsonNode.get("color").asText();
		System.out.println("Color: " + color);
	}
}
