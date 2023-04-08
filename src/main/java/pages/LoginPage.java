package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import excelutility.Xls_Reader;

public class LoginPage extends BaseClass {
	
	String path = System.getProperty("user.dir");
	
	
	@FindBy(css="#email")
	WebElement email;
	
	@FindBy(css="#pass")
	WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[text()='Wrong credentials']")
	WebElement validationMsg;
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
	}
	
	
	/** This method enter credentials and click on login button
	 * Created by Tejas Toley
	 * @param emailField
	 * @param pass
	 */
	public void enterCredentials() {
		 Xls_Reader xls_reader = new Xls_Reader(path+"\\src\\main\\java\\testdata\\data.xlsx");
		 int rowCount =  xls_reader.getRowCount("Sheet1");
		 
		 for(int i=2; i<=rowCount; i++) {
			 String userNameField = xls_reader.getCellData("Sheet1", "UserName", i);
			 String passwordField =  xls_reader.getCellData("Sheet1", "PassWord", i);
			 
			 email.clear();
			 email.sendKeys(userNameField);
			 
			 password.clear();
			 password.sendKeys(passwordField);
			 loginBtn.click();
			 
			 if(validationMsg.isDisplayed()) {
				 xls_reader.setCellData("Sheet1","Test Case Result", i,"Pass");
			 }
			 else
				 xls_reader.setCellData("Sheet1","Test Case Result", i,"Fail");
			}
         }
}
