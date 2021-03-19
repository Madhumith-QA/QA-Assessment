package CRUDValidation;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBvalidation {

static Connection con = null;

private static Statement stmt;

public static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

public static String DB_USER = "postgres";

public static String DB_PASSWORD = "postgres";

@BeforeTest
public void setUp() throws Exception {
try{

	Class.forName("org.postgresql.Driver");


Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

stmt = con.createStatement();
}
catch (Exception e)
{
e.printStackTrace();
}
}

@Test
public void Create() {
try{
	 String CreateSql = "CREATE TABLE public.employee2(id int,name varchar, address text) ";

ResultSet res = stmt.executeQuery(CreateSql);

if(res!=null) {
while (res.next())
{
System.out.print(res.getString(1));
System.out.print(" " + res.getString(2));
System.out.print(" " + res.getString(3));
System.out.println(" " + res.getString(4));
}
}
else {
	Reporter.log(res.toString());
	Assert.fail();
	}
}
catch(Exception e)
{
	System.err.println( e.getClass().getName()+": "+ e.getMessage() );
}
}
@Test
public void Insert() {
try{
	String insert = "INSERT INTO employee2(id,name,address) VALUES(1,'Madhu','Madurai');";

	ResultSet res = stmt.executeQuery(insert);
      
       
       if(res==null) {
        	Reporter.log(res.toString());
        	Assert.fail();
        	}
        }


    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}  
@Test
public void Read() {
try{
	 String read = "select * from public.employee2 ;";

ResultSet res = stmt.executeQuery(read);

if(res!=null) {
while (res.next())
{
System.out.print(res.getString(1));
System.out.print(" " + res.getString(2));
System.out.print(" " + res.getString(3));
System.out.println(" " + res.getString(4));
}
}
else {
	Reporter.log(res.toString());
	Assert.fail();
	}
}
catch(Exception e)
{
	System.err.println( e.getClass().getName()+": "+ e.getMessage() );
}
}

@Test
public void Update() {
try{
	String update = "UPDATE employee2 "
            + "SET name = ? "
            + "WHERE id = ?";

    int affectedrows = 0;

    PreparedStatement pstmt=con.prepareStatement(update);  

        pstmt.setString(1, "madhu");
        pstmt.setInt(2, 2);

        affectedrows = pstmt.executeUpdate();
       
       
        if(affectedrows==0) {
        	Reporter.log(pstmt.toString());
        	Assert.fail();
        	}
        }


    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}  
@Test
public void Delete() {
try{
	String delete = "DELETE FROM employee2 WHERE id = ?";

    int affectedrows = 0;

   PreparedStatement pstmt = con.prepareStatement(delete);

      
        pstmt.setInt(2, 2);

        affectedrows = pstmt.executeUpdate();
       
       
        if(affectedrows==0) {
        	Reporter.log(pstmt.toString());
        	Assert.fail();
        	}
        }


    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}  



@AfterTest
public void tearDown() throws Exception {
// Close DB connection
if (con != null) {
con.close();
}
}
}