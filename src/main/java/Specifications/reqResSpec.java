package Specifications;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class reqResSpec {

	RequestSpecBuilder requestBuilder;
	RequestSpecification requestSpec;
	ResponseSpecBuilder responseBuilder;
	ResponseSpecification responseSpec;
	
	@BeforeTest
	public void setup() {
		requestBuilder=new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://reqres.in/");
		requestBuilder.setBasePath("api/");
		requestBuilder.addQueryParam("page", 2);
		requestSpec=requestBuilder.build();
		
		responseBuilder=new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectBody("data[0].id", equalTo(7));
		responseSpec=responseBuilder.build();
	}
	
	@Test
	public void test() {
		RestAssured.given().
			spec(requestSpec).
			when().
			get("users").
			then().
			spec(responseSpec);
	}
}
