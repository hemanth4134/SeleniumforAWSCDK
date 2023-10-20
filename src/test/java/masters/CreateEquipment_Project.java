package masters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;




public class CreateEquipment_Project {
	WebDriver driver;
	GBCSTestScreenshots ts;
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tnctrackertest.godrej.com/serviceequipmentmaster");
		driver.manage().window().maximize();
		ts=new GBCSTestScreenshots();
		LoginPage lp=new LoginPage();
		lp.valid_UserLogin(driver,"dsp","Gitl@2022aa","user");
		Thread.sleep(3000);
		
	}
	@Test(priority=5,dataProvider="addequipdp",enabled=true)
	public void addequipement(String tc,String servicename,String equipmentname,String func,String prefun) throws InterruptedException
	{
		//steps
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,'Add New Equipment')]")).click();
		 Thread.sleep(2000);
		    driver.findElement(By.id("ServiceCode")).click();
		    {
		      WebElement dropdown = driver.findElement(By.id("ServiceCode"));
		      if(servicename.equals("Electrical"))
		      {
		      dropdown.findElement(By.xpath("//option[. = 'Electrical']")).click();
		      }
		      else
		      { 
		    	  dropdown.findElement(By.xpath("//option[. = 'Mechanical']")).click();  
		      }
		      
		   
		    }
		  
		    driver.findElement(By.xpath("//input[@value='Equipment']")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//label[contains(.,'Equipment / Activity')]")).click();
		    driver.findElement(By.id("EquipmentName")).sendKeys(equipmentname);
		    if(func.contains("yes"))
		    {
		    driver.findElement(By.xpath("(//*[@id='EquipApplicableChecklist'])[1]")).click();
		    }
		    Thread.sleep(1000);
		    if(prefun.contains("yes"))
		    {
		    	 driver.findElement(By.xpath("(//*[@id='EquipApplicableChecklist'])[2]")).click();
		    }
		    Thread.sleep(1000);
		  //  driver.findElement(By.xpath("//input[@name='DeleteIndication']")).click();
		    Thread.sleep(1000);
		    ts.takePageScreenshot_onPass(driver, tc+"pic1");
		    if(tc.equals("reset data"))
		    {
		    	driver.findElement(By.xpath("//button[text()='Reset Fields']")).click();
				 Thread.sleep(1000);
	
				 ts.takePageScreenshot_onPass(driver, tc+"after reset");
				 Thread.sleep(1000);
		    }
		    else
		    {
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    }
		    Thread.sleep(1000);
		    try {
				driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		    Thread.sleep(1000);
		    try {
				driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
				 Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, tc+"pic2");
				Thread.sleep(500);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}
		    
		    Thread.sleep(1000);
		    try {
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		    Thread.sleep(2000);
	}
	
	@Test(priority=7,dataProvider="addproj")
	public void addProj_tab1(String tc,String status,String projcode,String projname,String projarea,String org_value,String revised_value) throws InterruptedException
	{
		//stepsString tc,String status,String projcode,String projname,String projarea,String org_value,String revised_value
		driver.navigate().to("https://tnctrackertest.godrej.com/projectmaster");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add New Project']")).click();
		Thread.sleep(3000);
		Select projstatus=new Select(driver.findElement(By.xpath("//select[@name='DeleteIndication']")));
		projstatus.selectByIndex(0);
		driver.findElement(By.xpath("//input[@name='ProjectCode']")).sendKeys(projcode);
		driver.findElement(By.xpath("//input[@name='ProjectName']")).sendKeys(projname);
		
		Select sector=new Select(driver.findElement(By.xpath("//select[@name='Sector']")));
		sector.selectByIndex(1);
		driver.findElement(By.cssSelector("#projectdetails > div > div:nth-child(1) > div:nth-child(7) > div > svg")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='selection0'])[1]")).click();
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='ProjEndDate']")).click();
	
		 Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name='ProjEndDate']")).sendKeys(Keys.ARROW_UP);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name='ProjEndDate']")).sendKeys(Keys.ARROW_RIGHT);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name='ProjEndDate']")).sendKeys(Keys.ARROW_UP);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name='ProjArea']")).clear();
		  driver.findElement(By.xpath("//input[@name='ProjArea']")).sendKeys(projarea);
		  Select projzone=new Select(driver.findElement(By.xpath("//select[@name='Zone']")));
		  projzone.selectByIndex(1);
		  driver.findElement(By.xpath("//input[@name='OriginalOrderValue']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		  driver.findElement(By.xpath("//input[@name='OriginalOrderValue']")).sendKeys(org_value);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name='RevisedOrderValue']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		  driver.findElement(By.xpath("//input[@name='RevisedOrderValue']")).sendKeys(revised_value);
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, tc+"pic1");
		  Thread.sleep(1000);
		  driver.findElement(By.cssSelector("#projectdetails > div > div:nth-child(1) > div:nth-child(20) > div > svg")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//input[@id='selection0'])[1]")).click();
		  driver.findElement(By.xpath("//button[text()='Add']")).click();
		 
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  Thread.sleep(1000);
		  Actions act=new Actions(driver);
		  act.click( driver.findElement(By.xpath("//div[text()='Customer Details']")));
		  act.build().perform();
		  act.sendKeys(Keys.PAGE_DOWN);
		  act.build().perform();
		  Thread.sleep(1000);
		  //customer
		  driver.findElement(By.cssSelector("#projectdetails > div > div:nth-child(3) > div:nth-child(1) > div > svg")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//input[@id='selection2'])[1]")).click();
		  driver.findElement(By.xpath("//button[text()='Add']")).click();
		  Thread.sleep(1000);
		  //contact person1
		  driver.findElement(By.cssSelector("#projectdetails > div > div:nth-child(3) > div:nth-child(3) > div > svg")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//input[@id='selection0'])[1]")).click();
		  driver.findElement(By.xpath("//button[text()='Add']")).click();
		  Thread.sleep(2000);
		
		 
		 
		  driver.findElement(By.xpath("//button[text()='Save']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver, tc+"pic2");
		  
		
		  try {
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		  driver.navigate().refresh();
		  Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementById('ProjEndDate').setAttribute('value', '2023-06-30')");
	}
	@DataProvider
	  public Object[][] addequipdp() {
	    return new Object[][] {
//	    	
	    	 new Object[] { "valid equipement","Electrical","Automation ep4","yes","no" },
	    	// new Object[] { "valid equipement max char","Mechanaical","Automation equipement2Automation equipement2Automation equipement2Automation equipement2Automation equipement2","yes","yes" }, 
//	    	
	    };
	  }
	@DataProvider
	  public Object[][] addproj() {
	    return new Object[][] {
	    	 
	    	 new Object[] { "valid project","active","automation_ep4","automation_ep4","1000","20000","30000" }, 
	    	
	  
	    };
	  }
}
