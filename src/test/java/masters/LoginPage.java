package masters;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



public class LoginPage {
	
	WebDriver w;
	String url=""; 
	//change xpaths accordingly
	By username = By.xpath("//input[@name='userName']"); //step1: username xpath locator-change accordingly

	By password = By.xpath("//input[@name='password']"); //step2: password xpath locator-change accordingly
	By submit = By.xpath("//button[text()='Login']"); //step3:sign-in or submit locator-change accordingly

	By userid=By.id("mat-input-0");	

	By passwordid=By.id("mat-input-1");	
	By user_radio=By.xpath("//input[@value='User']");
	//follow steps 4 and 5 defined in testcases.TpcLogin
	By employee_radio=By.xpath("//input[@value='Godrej Employee']");
	By userlogo=By.xpath("/html/body/app-root/app-header/header/mat-toolbar/div[2]/div/ul/li[2]/a/img");
	By logout=By.xpath("/html/body/div[2]/div[2]/div/div/div/button");
	By usererror=By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/div[3]/mat-card-content/form/mat-form-field[1]/div/div[3]/div/mat-error");
	By passworderror;
	String invaliderrormsg="";
	By invalidusrpass=By.xpath("/html/body/div[1]/div/div");
	By dashborad=By.tagName("h1");
	By tpcuser=By.xpath("//*[@id='mat-input-0']");
	By tpcpassword=By.xpath("//*[@id='mat-input-1']");
	By tpcsubmit=By.xpath("/html/body/app-root/app-login/div/div[2]/div/form/mat-card-content/button");
	//GBCSTestScreenshots ts;
	int screen=1;
	public void  LoginPageURL(WebDriver w,String url) throws InterruptedException
	{
		this.w=w;
		this.url=url;
		w.get(url);
		Reporter.log("step1: URL opened");
	//	ts=new GBCSTestScreenshots();
		Thread.sleep(10000);
		//WebDriverWait wait = new WebDriverWait(w, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(supplierradio));
		
	}
	public boolean usernamepresent()
	{
		boolean booluser=  w.findElement(username).isDisplayed();
		return booluser;
	}
	public boolean passwordpresent()
	{
		boolean boolpass=  w.findElement(password).isDisplayed();
		return boolpass;
	}public boolean submitpresent()
	{
		boolean boolsub=  w.findElement(submit).isDisplayed();
		return boolsub;
	}
	public String usererrormsg()
	{
		String msg="" ;
		msg=w.findElement(usererror).getText();
		return msg;

	}
	public String passworderrormsg()
	{
		String msg="" ;
		passworderror=By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/div/div[3]/mat-card-content/form/mat-form-field[2]/div/div[3]/div/mat-error/span");
		msg=w.findElement(passworderror).getText();
		return msg;

	}
	public void valid_UserLogin(WebDriver w,String user,String pass,String ustype) throws InterruptedException
	{
		Thread.sleep(2000);
		w.findElement(user_radio).click();
		Thread.sleep(1000);
		//w.findElement(username).click();
		w.findElement(username).sendKeys(user); 
		//w.findElement(password).click();
		w.findElement(password).sendKeys(pass);
		Reporter.log("Entered username and password");
		Thread.sleep(2000);
		w.findElement(submit).click();
		Thread.sleep(5000);
	}
	//use this method if login page has usertype field for ex:- supplier and employee
	

	public boolean usernamepresent_noUsrType()
	{
		boolean booluser=  w.findElement(tpcuser).isDisplayed();
		return booluser;
	}
	public boolean passwordpresent_noUsrType()
	{
		boolean boolpass=  w.findElement(tpcpassword).isDisplayed();
		return boolpass;
	}public boolean submitpresent_noUsrType()
	{
		boolean boolsub=  w.findElement(tpcsubmit).isDisplayed();
		return boolsub;
	}
	
// to logout and close
	public void  prodconf_userlogoutandClose(WebDriver w) throws InterruptedException
	{
		// userlogo xpath to be changed accordingly
		w.findElement(userlogo).click();
		Thread.sleep(1000);
		// logout button/link xpath to be changed accordingly
		w.findElement(logout).click();
		Thread.sleep(1000);
		Reporter.log("logout");
		w.close();

	}

}
