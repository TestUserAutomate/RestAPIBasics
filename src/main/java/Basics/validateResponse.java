package Basics;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*; //manual import mandatory

public class validateResponse {
	/***
	 * 	Given I have this information
		When I perform this action
		Then this should be the output
	 */
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users";
	}
	
	@Test
	public void responseValidationTest() {
		RestAssured.given().
		 param("page", "2").
		when(). 
		 get(). 
		then().
		 statusCode(200).
		 body("data[0].email", equalTo("michael.lawson@reqres.in")).
		 contentType(ContentType.JSON);
	}
}
