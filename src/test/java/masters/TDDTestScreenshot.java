package masters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;



//import org.testng.Reporter;


public class TDDTestScreenshot {
public String Enq="",search_eq="";

Calendar cal = Calendar.getInstance();
String destination;
SimpleDateFormat simpleformat = new SimpleDateFormat("d-MMM-YY HH-mm");
String imagetime="";
String dir ="";

	public TDDTestScreenshot() {
		// TODO Auto-generated constructor stub
		 imagetime=simpleformat.format(cal.getTime());
		// destination=System.getProperty("user.dir")+"/Test case screenshots/"+imagetime+"/"+tc+".png";
		  dir = "C:\\java project\\DemoblazeTDD\\Test case screenshots\\"+imagetime+"\\";
		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
		File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
	}
	
	public void extentscreenshot(WebDriver driver,String tc)
	{
//		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
//		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", tc);
		
	
	}
	public void takePageScreenshot_onFail(WebDriver w,String tc)
	{
		
			tc="FAIL "+tc;
	
		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
		
		TakesScreenshot ts=(TakesScreenshot)w;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//System.out.println("Today's date = "+simpleformat.format(cal.getTime()));
		//String imagetime=simpleformat.format(cal.getTime());
		//String dir = "C:\\java project\\DemoBlazeBDD\\Test case screenshots\\"+imagetime+"\\";

        
		String destination=dir+"\\"+tc+".png";
		//https://godrej-my.sharepoint.com/:f:/r/personal/vparab_godrej_com/Documents/bdd/Test%20case%20screenshots?csf=1&web=1&e=0pbUyr
		//	String destination="C://Users//vparab//OneDrive - Godrej & Boyce Mfg. Co. Ltd//bdd//Test case screenshots//Run3//"+tc+imagetime+".png";
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
	
	public void takePageScreenshot_onPass(WebDriver w,String tc)
	{
		
		System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
		
		TakesScreenshot ts=(TakesScreenshot)w;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//System.out.println("Today's date = "+simpleformat.format(cal.getTime()));
		//String imagetime=simpleformat.format(cal.getTime());
		//String dir = "C:\\java project\\DemoBlazeBDD\\Test case screenshots\\"+imagetime+"\\";

        
		String destination=dir+"\\"+tc+".png";
		//https://godrej-my.sharepoint.com/:f:/r/personal/vparab_godrej_com/Documents/bdd/Test%20case%20screenshots?csf=1&web=1&e=0pbUyr
		//	String destination="C://Users//vparab//OneDrive - Godrej & Boyce Mfg. Co. Ltd//bdd//Test case screenshots//Run3//"+tc+imagetime+".png";
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

}
