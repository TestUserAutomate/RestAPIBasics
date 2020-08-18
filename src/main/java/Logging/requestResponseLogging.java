package Logging;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class requestResponseLogging {

	@Test
	public void validation() {
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.basePath="/users";
		
		//Logs can be used in both request and response
		//To debug the code
		
		RestAssured.given().
			log().
			//headers().
			//body().
			//parameters().
			//all().
			ifValidationFails().
			queryParam("page", "2").
			when().
			get().
			then().
			log().
			ifError().
			statusCode(200);
			
	}
	
}
