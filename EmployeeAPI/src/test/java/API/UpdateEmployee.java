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

public class UpdateEmployee implements Baseclass {

// Verify Status code as 200 

	@Test
	public void verifyupdateemp () {
		RestAssured.baseURI=baseurl;
		RequestSpecification upemp=RestAssured.given();
		
		 HashMap<String,Object> reqparams = new HashMap<String,Object>();
		 String employeeid=EmployeedetailsPOJO.getempid();
		 String employeename1=EmployeedetailsPOJO.getempfname();
		 String employeename2=EmployeedetailsPOJO.getemplname();
		 String employeedes=EmployeedetailsPOJO.getempdes();
		 reqparams.put("id",employeeid);
		 reqparams.put( "firstname",employeename1);
		 reqparams.put("lastname", employeename2);
		 reqparams.put("designation", employeedes);
		 reqparams.put("salary","");
		 JSONObject reqparam=new JSONObject(reqparams);
		 upemp.header("Content-Type","application/json");
		 upemp.body(reqparam.toJSONString());
		Response updateempres=upemp.put();
		Reporter.log("UpdateEmployee Employee"+updateempres.getBody().asString()); 
	    ValidatableResponse response_statuscode=updateempres.then();
	    response_statuscode.statusCode(200);
	   
	    }
	    }

