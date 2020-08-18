package Basics;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class getResponse {

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
	
	@Test(enabled=false)
	public void responseCode() {
		RestAssured.given().
		 param("page", "2").
		when()
		 .get().
		then().
		 statusCode(200);
	}
	
	@Test
	public void responseBody() {
		Response response=RestAssured.given().
			param("page","2").
		when().
			get();
		response.prettyPrint();
	}
	
}
