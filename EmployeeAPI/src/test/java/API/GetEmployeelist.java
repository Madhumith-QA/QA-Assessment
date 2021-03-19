package API;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.Baseclass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetEmployeelist implements Baseclass{

// Verify Status code as 200 
// Verify response have duplicate employee id
	@Test
	public void verifyemployeelist() {
		RestAssured.baseURI=baseurl;
		RequestSpecification emplistreq=RestAssured.given();
		Response emplistres=emplistreq.get();
		Reporter.log("Get Employee"+emplistres.getBody().asString()); 
	    ValidatableResponse response_statuscode=emplistres.then();
	    response_statuscode.statusCode(200);
	    List<String> listoppno = emplistres.jsonPath().getList("id");
	    System.out.println(listoppno);
	  
	    for(int i=0;i<listoppno.size()-1;i++) {
	    	
	    	Assert.assertNotEquals(listoppno.get(i),listoppno.get(i+1),"Duplicate Id found");
	    	}
	    }
	    }

