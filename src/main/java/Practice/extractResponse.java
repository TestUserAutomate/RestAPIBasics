package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class extractResponse {

	@Test
	public void validation() {
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.basePath="/users";
		
		Response response=RestAssured.given().
			queryParam("page", "2").
			when().
			get().
			then().
			statusCode(200).
			extract().response();
	
		//validating responses
		
		//1st way- using path
		int id=response.path("data[1].id");
		System.out.println(id);
		Assert.assertEquals(id, 8);
			
		//2nd way using JsonPath
		String res=response.asString();
		JsonPath json=new JsonPath(res);
		String company=json.get("ad.company");
		System.out.println(company);
		
		
	}
	
}
