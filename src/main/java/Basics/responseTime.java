package Basics;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class responseTime {
	@Test
	public void test() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/";
		
		RestAssured.given().
			queryParam("page", 2).
			when().
			get("users").
			//timeIn(TimeUnit.MILLISECONDS);
			then().
			statusCode(200).
			time(lessThan(800L), TimeUnit.MILLISECONDS).
			body("total", equalTo(12)).
			body("data[0].first_name", equalTo("Michael")).
			body("data.size()", lessThan(7));	
	
	}
}
