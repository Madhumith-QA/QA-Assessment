package API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.Baseclass;
import Utilities.EmployeedetailsPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteEmployee implements Baseclass{

// Verify Status code as 410 

	@Test
	public void verifyupdateemp() {
		RestAssured.baseURI=baseurl;
		String employeeid=EmployeedetailsPOJO.getempid();
		System.out.println(employeeid);
		RequestSpecification upemp=RestAssured.given();
		upemp.header("Content-Type","application/json");
	
		Response emplistres=upemp.delete(employeeid);
		 Reporter.log("Delete employee"+emplistres.getBody().asString()); 
	    ValidatableResponse response_statuscode=emplistres.then();
	    response_statuscode.statusCode(410);
	   
	    }
	    }

