package Basics;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class postWithPOJO {
	/***
	 * 	Given I have this information
		When I perform this action
		Then this should be the output
	 */
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI="http://localhost:3000/";
		RestAssured.basePath="posts";
	}
	
	@Test
	public void postValidation() {
		//add jackson api- used for converting java objects into json
		//Initialize the body elements in seperate class with getters & setters
		
		POJOforPost pojo=new POJOforPost(); 
		pojo.setId(7);
		
		RestAssured.given().
			body(pojo).
			when().
				post().
			then().
				statusCode(200);
	}
	
}

