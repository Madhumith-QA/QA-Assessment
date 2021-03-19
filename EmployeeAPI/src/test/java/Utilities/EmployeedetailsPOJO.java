package Utilities;

public class EmployeedetailsPOJO {
	public static String EmployeeId;
	private static String EmployeeFname;
	private static String EmployeeLname;
	private static  String EmployeeDesignation;
	private static String EmployeeSalary;
	
	public EmployeedetailsPOJO(String employeeId, String employeeFname, String employeeLname,String employeeDesignation,
			String employeeSalary) {
		
		EmployeeId = employeeId;
		EmployeeFname = employeeFname;
		EmployeeLname = employeeLname;
		EmployeeDesignation=employeeDesignation;
		EmployeeSalary=employeeSalary;
	}

	public static String getempid() {
		return EmployeeId;
	}
	public void setempid(String EmployeeId) {
		EmployeedetailsPOJO.EmployeeId = EmployeeId;
	}
	public static String getempfname() {
		return EmployeeFname;
	}
	public void Setempfname(String EmployeeFname) {
		EmployeedetailsPOJO.EmployeeFname = EmployeeFname;
	}
	public static String getemplname() {
		return EmployeeLname;
	}
	public void setemplname(String EmployeeLname) {
		EmployeedetailsPOJO.EmployeeLname = EmployeeLname;
	}
	public static String getempdes() {
		return EmployeeDesignation;
	}
	public void setempdes(String EmployeeDesignation) {
		EmployeedetailsPOJO.EmployeeDesignation = EmployeeDesignation;
	}
	public static String getempsal() {
		return EmployeeSalary;
	}
	public void setempsal(String EmployeeSalary) {
		EmployeedetailsPOJO.EmployeeSalary = EmployeeSalary;
	}
	
}