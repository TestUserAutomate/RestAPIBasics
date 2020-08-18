package Assertions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

public class HardAssert {
	
	@Test
	public void test() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/";
		
		RestAssured.given().
			queryParam("page", 2).
			when().
			get("users").
			then().
			statusCode(200).
			body("total", equalTo(12)).
			body("data[0].first_name", equalTo("Michael")).
			body("data.size()", lessThan(7));
			
	
	}

}
