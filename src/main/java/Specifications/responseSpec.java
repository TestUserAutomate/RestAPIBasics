package Specifications;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class responseSpec {

	ResponseSpecBuilder builder;
	ResponseSpecification responseSpec;
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
		
		builder=new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectBody("total_pages", equalTo(2));
		responseSpec=builder.build();
	}
	
	@Test
	public void test() {
		RestAssured.given().
			queryParam("page", 2).
			when().
			get("/users").
			then().
			spec(responseSpec);
	}
	
}
