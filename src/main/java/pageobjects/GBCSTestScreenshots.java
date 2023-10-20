package pageobjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;


public class GBCSTestScreenshots {
public String Enq="",search_eq="";



	public GBCSTestScreenshots() {
		// TODO Auto-generated constructor stub
	}
	
	public void printAlertmsg(WebDriver w) throws InterruptedException
	{
		String msg1="",msg2="",msg3="",msg4="";
		Thread.sleep(1000);
		try {
			msg1=w.findElement(By.xpath("//div[contains(text(),'want')]")).getText();
			//
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
				Reporter.log(msg1+ "<br>");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(1000);
		
try {
			
			
			msg3=w.findElement(By.xpath("//div[contains(text(),'Customer already')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg3+ "<br>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		try {
			
			w.findElement(By.xpath("//button[text()='Yes']")).click();
			Thread.sleep(1000);
			msg3=w.findElement(By.xpath("//div[contains(text(),'Great')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg3+ "<br>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(500);
		try {
			msg4=w.findElement(By.xpath("//div[contains(text(),'Great')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg4+ "<br>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		try {
			msg4=w.findElement(By.xpath("//div[contains(text(),'already')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg4+ "<br>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		try {
			msg4=w.findElement(By.xpath("//div[contains(text(),'linked')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg4+ "<br>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		try {
			msg4=w.findElement(By.xpath("//div[contains(text(),'Success')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg4+ "<br>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		// eq
		try {
			msg4=w.findElement(By.xpath("//div[contains(text(),'Enquiry')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg4+ "<br>");
			Enq=msg4;
			search_eq=Enq.replaceAll("[^0-9]", "");
			Reporter.log(search_eq+ "<br>");
			Enq=search_eq.substring(6, search_eq.length());
			Reporter.log(Enq+ "<br>");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		try {
			msg4=w.findElement(By.xpath("//div[contains(text(),'Updated')]")).getText();
			Reporter.log("<h2 style='color:orange'>Alert message is </h2>");
			Reporter.log(msg4+ "<br>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(500);
		try {
			w.findElement(By.xpath("(//button[@aria-label='Close'])[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(1000);
		try {
			w.findElement(By.xpath("(//button[@aria-label='Close'])[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(500);
				try {
					w.findElement(By.xpath("(//button[@aria-label='Close'])[2]")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
				Thread.sleep(500);
	}
	public void takePageScreenshot_onPass(WebDriver w,String tc)
	{
		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
		TakesScreenshot ts=(TakesScreenshot)w;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/Test case screenshots/"+tc+".png";
		
		//String destination="file:///C:/java%20project/Sel_Jenkins_proj1/Test case screenshots/"+tc+".png";
	File finaldestination=new File(destination);
	
	try
	{
		FileHandler.copy(source,finaldestination);
		String imgpath=finaldestination.toString();
		Reporter.log("<img src='"+imgpath+"' height='400' width='700' />");
		//Reporter.log("Saved <a href='" + imgpath + "'>"+tc+"</a>");
		//Reporter.log("Saved <a href='" + "http://localhost:8080/job/OrangeHRMDemoQA_JenkinsTest/Sel_Jenkins_proj1$Sel_Jenkins_proj1/ws"+"/Test case screenshots/"+tc+".png" + "'>"+tc+"</a>");

	}
	catch(Exception e)
	{}
	}
	public void takeElementScreenshot_onPass(WebElement w,String tc,String file)
	{
		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
		//System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		//TakesScreenshot ts=(TakesScreenshot)w;
		File source=w.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/Test Case ScreenShots/"+file+"/"+tc+".png";
		
		//String destination="file:///C:/java%20project/Sel_Jenkins_proj1/Test case screenshots/"+tc+".png";
	File finaldestination=new File(destination);
	
	try
	{
		FileHandler.copy(source,finaldestination);
		String imgpath=finaldestination.toString();
		Reporter.log(tc+"<br>");
		Reporter.log("<img src='"+imgpath+"' />"+"<br>");
		//Reporter.log("<a href=\""+ imgpath + "\"> link to ss" +"</a>" );
		//Reporter.log("Saved <a href='" + imgpath + "'>"+tc+"</a>");
		//Reporter.log("Saved <a href='" + "http://localhost:8080/job/OrangeHRMDemoQA_JenkinsTest/Sel_Jenkins_proj1$Sel_Jenkins_proj1/ws"+"/Test case screenshots/"+tc+".png" + "'>"+tc+"</a>");

	}
	catch(Exception e)
	{}
	}

}
