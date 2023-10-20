package masters;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
public class GBCS_SOR {

	WebDriver driver;
	GBCSTestScreenshots ts;
	WebDriverWait wt;
	String empid="";
	int docid=2;
	int tab4record=2;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	User_Master us = new User_Master();
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		
	//	System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.edge.driver", "./Browsers/msedgedriver.exe");
//		driver = new EdgeDriver();
		wt=new WebDriverWait(driver, Duration.ofSeconds(10));
		  js = (JavascriptExecutor)driver;	
		driver.get("https://tnctrackertest.godrej.com");

		driver.manage().window().maximize();
		Thread.sleep(4000);

		ts=new GBCSTestScreenshots();
		Thread.sleep(1000);
		/*driver.findElement(By.xpath("//button[text()='Login']")).click();
//		LoginPage lp=new LoginPage();
//		lp.valid_DealerLogin(driver, "harshali", "@venGers100", "Dealer");
//		Thread.sleep(1000);*/

	LoginPage lp=new LoginPage();
		lp.valid_UserLogin(driver, "dsp", "Gitl@2022aa", "Dealer");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".head-toggle")).click();
		driver.findElement(By.cssSelector(".list3:nth-child(6) .menu-name")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Site Observation Report")).click();
		Thread.sleep(3000);
		//driver.navigate().refresh();
	}
	@Test(priority = 0,enabled = true)
	public void checkraisedby() throws InterruptedException
	{
		Thread.sleep(1000);	
		driver.get("https://tnctrackertest.godrej.com/usermaster");
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys("dsp");
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "dsp details");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys("vparab");
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "vparab details");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".head-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".list3:nth-child(6) .menu-name")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Site Observation Report")).click();
		Thread.sleep(3000);
	}
	@Test(priority = 1,enabled = true)
	public void selectproject() throws InterruptedException
	{Thread.sleep(1000);
		driver.findElement(By.cssSelector("#root > div > div.app-container > div.main-container.container-fluid > div.action-comp-container.container-fluid > div > div:nth-child(1) > div > svg")).click();
		Thread.sleep(1000);
		try {
			driver.findElement(By.cssSelector("#root > div > div.app-container > div.main-container.container-fluid > div.action-comp-container.container-fluid > div > div.action-project.col-lg-3.col-md-3.col-12 > div > svg")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).click();
		
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys("july");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='selection0']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		Thread.sleep(1000);
	}
	@Test(priority = 2,enabled = true,dataProvider = "AddSOR")
	public void Addmethod(String tc,String issuedt,String floor,String area,String equipact,String actcapa,String issuedesc,String remark,String closedt,String correctaction) throws InterruptedException {
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		driver.findElement(By.cssSelector(".add-btn-label")).click();
		try {
			driver.findElement(By.cssSelector(".add-btn-label")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(3000);
		driver.findElement(By.id("IssueDate")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("IssueDate")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("IssueDate")).click();
		Thread.sleep(2000);
	    driver.findElement(By.id("IssueDate")).sendKeys(issuedt);
	    Thread.sleep(1000);
		driver.findElement(By.id("FloorNo")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("FloorNo")).sendKeys(floor);
		Thread.sleep(1000);
		driver.findElement(By.id("Area")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Area")).sendKeys(area);
		Thread.sleep(1000);
		if(tc.equals("editable service"))
		{
			
			driver.findElement(By.xpath("//input[@id='ServiceName']")).sendKeys("test/suite 123@#$%^.(_) -{}dsp[]");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='EquipmentActivityName']")).sendKeys("test/suite 123@#$%^.(_) -{}dsp[]");
		}
		else
		{
			Thread.sleep(2000);
		driver.findElement(By.cssSelector(".col-lg-4:nth-child(6) .modalPopUpIconProjDetails")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("selection0")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".me-2:nth-child(1)")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#siteobservationreport > div:nth-child(1) > div:nth-child(9) > div > svg")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("selection0")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".me-2:nth-child(1)")).click();
		Thread.sleep(1000);
		}
		driver.findElement(By.cssSelector(".col-lg-4:nth-child(10) .frm-label")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("EquipmentActivityTagSrNo")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("EquipmentActivityTagSrNo")).sendKeys(equipact);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".col-lg-4:nth-child(11) .frm-label")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("EquipmentActivityCapacity")).sendKeys(actcapa);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#siteobservationreport > div:nth-child(1) > div:nth-child(12) > div > svg")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("selection0")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".me-2:nth-child(1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("IssueDescription")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("IssueDescription")).sendKeys(issuedesc);
		Thread.sleep(1000);
		driver.findElement(By.id("Remarks")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Remarks")).sendKeys(remark);
		
		Thread.sleep(2000);
		ts.takePageScreenshot_onPass(driver, tc+"pic1");
		Thread.sleep(1000);
		driver.findElement(By.id("AnticipatedClosureDate")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("AnticipatedClosureDate")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("AnticipatedClosureDate")).click();
		Thread.sleep(2000);
	    driver.findElement(By.id("AnticipatedClosureDate")).sendKeys(closedt);
	    Thread.sleep(2000);
	    if(tc.contains("check critical and max char"))
	    {
	    	Thread.sleep(1000);
	    	driver.findElement(By.xpath("//input[@value='Critical']")).click();
			Thread.sleep(1000);
	    }
		driver.findElement(By.id("CorrectiveAction")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CorrectiveAction")).sendKeys(correctaction);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(1000);
		if(!tc.equals("mandatory field validation"))
		{
		driver.findElement(By.xpath("//*[text()='Select a file']")).click();
		Thread.sleep(4000);
		String filepath1 = "C:\\Users\\vparab\\Documents\\Passed_TCs.pdf";
		us.uploadFile(filepath1);
		ts.takePageScreenshot_onPass(driver, "file1");
		Thread.sleep(1000);
		}
		if(tc.equals("check file uploads"))
		{
			Thread.sleep(3000);
			act.click(driver.findElement(By.xpath("//*[text()='Upload']")));
			act.build().perform();
			act.sendKeys(Keys.PAGE_DOWN);
			act.build().perform();
			Thread.sleep(1200);
			driver.findElement(By.xpath("(//img[@alt='delete'])[3]")).click();
			Thread.sleep(1000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block			
			}
			String filepath1 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Employee Information.pptx";
			String filepath2 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Automation_Testing_QG_V1.docx";
			String filepath3 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Autmation ROI calculation.xlsx";
			String filepath4 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Report1.JPG";
			String filepath5 = "C:\\Users\\vparab\\Documents\\dump\\dump\\TestAutomationStrategy7681043.png";
			driver.findElement(By.xpath("//*[text()='Select a file']")).click();
			Thread.sleep(4000);
			us.uploadFile(filepath1);
			ts.takePageScreenshot_onPass(driver, "file2");
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[3]")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
			Thread.sleep(1000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block			
			}
			driver.findElement(By.xpath("//*[text()='Select a file']")).click();
			Thread.sleep(3000);
			us.uploadFile(filepath2);
			ts.takePageScreenshot_onPass(driver, "file3");
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[3]")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
			Thread.sleep(1000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block			
			}
			driver.findElement(By.xpath("//*[text()='Select a file']")).click();
			Thread.sleep(3000);
			us.uploadFile(filepath3);
			ts.takePageScreenshot_onPass(driver, "file4");
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[3]")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch blok
			}
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block			
			}
			driver.findElement(By.xpath("//*[text()='Select a file']")).click();
			Thread.sleep(3000);
			us.uploadFile(filepath4);
			ts.takePageScreenshot_onPass(driver, "file4");
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[3]")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block			
			}
			driver.findElement(By.xpath("//*[text()='Select a file']")).click();
			Thread.sleep(3000);
			us.uploadFile(filepath5);
		}
		Thread.sleep(2000);
	
		act.click(driver.findElement(By.xpath("//*[text()='Upload']")));
		act.build().perform();
		act.sendKeys(Keys.PAGE_DOWN);
		act.build().perform();
		Thread.sleep(1200);
		if(tc.contains("check critical and max char"))
	    {
	    	Thread.sleep(1000);
	    	driver.findElement(By.xpath("//input[@value='Yes']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "corrected yes");
			Thread.sleep(1000);
	    	driver.findElement(By.xpath("//input[@value='No']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "corrected no");
	    }
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//button[text()='Add']")).click();
			Thread.sleep(1000);	
			ts.takePageScreenshot_onPass(driver, tc+"pic2");
			Thread.sleep(1000);	
			driver.findElement(By.xpath("//button[text()='Yes']")).click();
			Thread.sleep(1000);	
				
			ts.takePageScreenshot_onPass(driver, tc+"pic3");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		//driver.findElement(By.cssSelector(".dropSelectText")).click();
	}
	@Test(dataProvider = "editsor",enabled = true,priority = 3)
	public void edit_sor(String tc,String floor) throws InterruptedException
	{
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(floor);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='23']//img[@alt='edit'])")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("EquipmentActivityTagSrNo")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("EquipmentActivityTagSrNo")).sendKeys("abc 12343 @#.-_()[]/ABCabc");
		driver.findElement(By.id("EquipmentActivityCapacity")).clear();
		driver.findElement(By.id("EquipmentActivityCapacity")).sendKeys("abc 12343 @#.-_()[]/ABCabc");
		driver.findElement(By.id("IssueDescription")).clear();
		driver.findElement(By.id("IssueDescription")).sendKeys("abc 12343 @#.-_()[]/ABCabc");
		ts.takePageScreenshot_onPass(driver, tc+"pic1");
		Actions act=new Actions(driver);
		act.click(driver.findElement(By.xpath("//div[text()='Edit']")));
		act.build().perform();
		act.sendKeys(Keys.PAGE_DOWN);
		act.build().perform();
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Yes']")).click();	
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, tc+"pic1");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
	}
	@Test(dataProvider = "deletesor",enabled = true,priority = 4)
	public void delete_sor(String tc,String floor) throws InterruptedException
	{
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(floor);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='23']//img[@alt='delete'])")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();	
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, tc+"pic1");
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//button[text()='OK']")).click();	
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
	}
	@DataProvider
	public Object[][] AddSOR() {
//	String issuedt,String floor,String area,String equipact,String actcapa,String issuedesc,String remark,String closedt,String correctaction
		return new Object[][] {
new Object[] {"future date sor","22-07-2023","102","1000sft","test123","act 1000","desc desc desc","all done","27-07-2023","taken correct action positively"},
new Object[] {"SOR date less than project","17-07-2023","102","1000sft","test123","act 1000","desc desc desc","all done","22-07-2023","taken correct action positively"},
new Object[] {"SOR date greater than project","19-08-2023","102","1000sft","test123","act 1000","desc desc desc","all done","24-08-2023","taken correct action positively"},	
new Object[] {"editable service","20-07-2023","102","1000sft","test123","act 1000","desc desc desc","all done","21-07-2023","taken correct action positively"},
new Object[] {"mandatory field validation","20-07-2023","","","","","","","25-07-2023",""},
new Object[] {"check file uploads","13-07-2023","105","1000sqft","test1234","act 10001","description test5","all done test5","18-07-2023","taken correct action positively test5"},	
new Object[] {"check critical and max char","20-07-2023","abc 12343 @#.-_()[]/ABCabc 12343abc 12343 @#.-_()[]/ABCabc 12343","abc 12343 @#.-_()[]/ABCabc 12343abc 12343 @#.-_()[]/ABCabc 12343","test123","@ 100000 one lakh sq.feet only/-","abc 12343 @#.-_()[]/ABCabc 12343abc 12343 @#.-_()[]/ABCabc 12343abc 12343 @#.-_()[]/ABCabc 12343","abc 12343 @#.-_()[]/ABCabc 12343abc 12343 @#.-_()[]/ABCabc 12343abc 12343 @#.-_()[]/ABCabc 12343","21-07-2023","taken correct action positively abc 12343 @#.-_()[]/ABCabc 12343"},	
		};
	}
	@DataProvider
	  public Object[][] editsor() {
	    return new Object[][] {
	    	
	    	 new Object[] { "update valid sor1","102"},
	    //	 new Object[] { "update valid sor2","102"},
//	    	
	    };
	  }
	
	@DataProvider
	  public Object[][] deletesor() {
	    return new Object[][] {
	    	
	    	 new Object[] { "delete valid sor1","102"},
	    	 new Object[] { "delete valid sor2","electric"},
//	    	
	    };
	  }
	// @AfterClass
		public void afterClass() {
			driver.close();
		}
}
