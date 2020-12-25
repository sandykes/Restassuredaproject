package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc1_ValidateGet {
	
	@Test
	void getUserdetails()
	{
		RestAssured.baseURI="https://reqres.in/api/";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/users?page1");
		String responseBody=response.getBody().asString();
		System.out.println("Response body is : "+responseBody);
		int statusCode=response.getStatusCode();
		System.out.println("Status code is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusline=response.getStatusLine();
		System.out.println("This is StatusLine : "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
	}
	

}
