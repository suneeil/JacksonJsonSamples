package com.org.parseExamples;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class TreeModel {

	@Test
	void treesample() throws JsonProcessingException, IOException {
		long id;
		String firstName = "";
		String middleName = "";
		String lastName = "";
		
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File("/Users/sunilrao/Workspace/EclipseWorkspace/JavaWorkSpace/jacksonjson/src/test/java/com/org/parseExamples/user.json"));
		
		
		id = root.path("id").asLong();
		System.out.println("Id: " + id);
		
		JsonNode nameNode = root.path("name");
		if(nameNode.isMissingNode()) {
			System.out.println("name node not found");
		}else {
			System.out.println("Found Name node");
			firstName = nameNode.path("first").asText();
			middleName = nameNode.path("middle").asText();
			
			lastName = nameNode.path("last").asText();
			System.out.println("firstName : " + firstName);
			System.out.println("middleName : " + middleName);
			System.out.println("lastName : " + lastName);
		}
		
		
		JsonNode contactNode = root.path("contact");
		if(contactNode.isArray()) {
			System.out.println("Contact os not array");
		}
		
		for(JsonNode node : contactNode) {
			String type = node.path("type").asText();
			String ref = node.path("ref").asText();
			System.out.println("type : " + type);
			System.out.println("ref : " + ref);
		}
		
		System.out.println("-------");
		ArrayNode arr =   (ArrayNode) root.path("contact");
		//arr.forEach(System.out::println);
		
		arr.forEach(j -> {
			System.out.println(j.path("ref"));
			System.out.println(j.path("type"));
		});
	}
}
