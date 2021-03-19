package API;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.Baseclass;
import Utilities.EmployeedetailsPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Getindividualemployeedata implements Baseclass{

// Need to run CreateEmployee and Getindividualemployeedata in testng.xml
// Verify Status code as 200 
	

	@Test
	public void verifyemployeedetails() {
		
		String employeeid=EmployeedetailsPOJO.getempid();
		RestAssured.baseURI=baseurl;
		RequestSpecification emplistreq=RestAssured.given();
		Response emplistres=emplistreq.get(employeeid);
		Reporter.log("Get individual Employee"+emplistres.getBody().asString()); 
	    ValidatableResponse response_statuscode=emplistres.then();
	    response_statuscode.statusCode(200);
	   
	    }
}
