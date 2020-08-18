package Basics;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class postResponse {
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
		RestAssured.given().
			body( "{"
			    +"\"id\": 5,"
			    +"\"title\": \"json-server\","
			    +"\"author\": \"typicode\""
			  +"}").
			when().
				post().
			then().
				statusCode(200);
	}
	
}
