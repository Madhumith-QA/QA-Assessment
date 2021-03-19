package in.samco.EmailFieldValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Emailfieldvalidation {
    
	WebDriver driver=new ChromeDriver();
    WebDriverWait wait=new WebDriverWait(driver,10);
	WebElement email;
	
	@BeforeTest
	public void verifyemailfield() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_validate_email");
	Thread.sleep(3000);
	driver.switchTo().frame("iframeResult");
	email=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("myInput")));
	}
	
	@Test(dataProvider = "Testdata",dataProviderClass = ReadExceldata.class)
	public void validation(String Emaildata,String Status) {
	email.sendKeys(Emaildata);
	WebElement emailcondition=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-binding")));
	String result=emailcondition.getText();
	email.clear();
    System.out.println(result);
	Assert.assertEquals(result, Status);
	 driver.close();
}
	 
	
}