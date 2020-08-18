package Specifications;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class requestSpec {
	
	RequestSpecBuilder builder; //to build the request
	RequestSpecification requestSpec; //to store the request built
	
	@BeforeTest
	public void setup() {
		builder=new RequestSpecBuilder();
		builder.setBaseUri("https://reqres.in");
		builder.setBasePath("/api/");
		builder.addQueryParam("page", 2);
		requestSpec=builder.build();
	}
		@Test
		public void test() {
			/*RestAssured.baseURI="https://reqres.in";
			RestAssured.basePath="/api/";*/
			RestAssured.given().
				spec(requestSpec).
				when().
				get("users").
				then().
				statusCode(200);
		}
	}

