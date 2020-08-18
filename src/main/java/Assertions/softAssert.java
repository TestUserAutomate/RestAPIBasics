package Assertions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class softAssert {
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
			body("total", equalTo(12),
			"data[0].first_name", equalTo("Michael1"),
			"data.size()", lessThan(6));
			
	
	}
}
