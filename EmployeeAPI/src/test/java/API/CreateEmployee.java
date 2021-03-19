package API;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import Utilities.Baseclass;
import Utilities.EmployeedetailsPOJO;
import Utilities.ReadExceldata;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class CreateEmployee implements Baseclass{
	public static List<EmployeedetailsPOJO> employeedetails = new ArrayList<>();
// Verify status code as 201 
// Verify response data matches with the request data
	@Test(dataProvider = "Testdata",dataProviderClass = ReadExceldata.class)
	public void verifycreateemployee(String firstname,String lastname,String designation,String salary,String Statuscode){
		String Employeeid = null;
		String Employeefname = null;
		String Employeedesignation = null;
		String Employeelname = null;
		String Employeesalary = null;
		
		try {
			
			RestAssured.baseURI=baseurl;
			RequestSpecification Createreq=RestAssured.given();
			 HashMap<String,Object> reqparams = new HashMap<String,Object>();
			 reqparams.put( "firstname",firstname);
			 reqparams.put("lastname", lastname);
			 reqparams.put("designation", designation);
			 reqparams.put("salary", salary);
			 JSONObject reqparam=new JSONObject(reqparams);
			 Createreq.header("Content-Type","application/json");
			 Createreq.body(reqparam.toJSONString());
			 Response employeeresponse=Createreq.post();
			 
		    ValidatableResponse response_statuscode=employeeresponse.then();
		    Reporter.log("Create Employee"+employeeresponse.getBody().asString()); 
			
			
		    switch (Statuscode) {
				case "201":
					response_statuscode.statusCode(201);
					 Employeeid=employeeresponse.jsonPath().getString("id");
					 Employeefname=employeeresponse.jsonPath().getString("firstname");
					Assert.assertEquals(Employeefname, firstname,"Firstname in response matches");
					Employeelname=employeeresponse.jsonPath().getString("lastname");
					Assert.assertEquals(Employeelname, lastname,"Lastname in response matches");
					Employeedesignation=employeeresponse.jsonPath().getString("designation");
					Assert.assertEquals(Employeedesignation, designation,"Designation in response matches");
					Employeesalary=employeeresponse.jsonPath().getString("salary");
					Assert.assertEquals(Employeesalary, salary,"Salary in response matches");
					System.out.println(Employeeid);
					employeedetails.add(new EmployeedetailsPOJO(Employeeid,Employeefname,Employeelname,Employeedesignation,Employeesalary));
					break;
				

					
				default:
					throw new AssertionError();

				}	
		}
		catch(Exception e) {
			
		}
	
	}
}
