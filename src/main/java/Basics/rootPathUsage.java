package Basics;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class rootPathUsage {
	@Test
	public void test() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/";
		RestAssured.rootPath="data[0]"; //specify root path here so that it can be passed to all the elements
		
		RestAssured.given().
			queryParam("page", 2).
			when().
			get("users").
			then().
			statusCode(200).
			body("id", equalTo(7)).
			body("email", equalTo("michael.lawson@reqres.in")).
			body("first_name", equalTo("Michael")).
			body("last_name", equalTo("Lawson"));
	
	}
}
