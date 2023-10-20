package masters;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

public class GBCS_ServiceMaster {
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
	@Test(enabled = true,priority = 0)
	public void Searchbystatus() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("Inactive");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(2000);
		ts.takePageScreenshot_onPass(driver, "Search by status");
		Reporter.log("Search_by_status");
		Thread.sleep(2000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
//		Thread.sleep(500);
	}	
		@Test(enabled = true,priority = 1)
		public void SearchbyServiceName() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@ref='eMenu'])[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("Mech");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
			Thread.sleep(2000);
			ts.takePageScreenshot_onPass(driver, "Search by ServiceName");
			Reporter.log("Search_by_Service Name");
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		
			
		}
		@Test(enabled = true,priority = 2)
		public void SearchbyEquipmentCode() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@ref='eMenu'])[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("007");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
			Thread.sleep(2000);
			ts.takePageScreenshot_onPass(driver, "Search by Equipment Code");
			Reporter.log("Search_by_Equipment Code");
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		
			
		}
		
		@Test(enabled = true,priority = 3)
		public void SearchbyEquipmentName() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("001");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
			Thread.sleep(2000);
			ts.takePageScreenshot_onPass(driver, "Search by Equipment Name");
			Reporter.log("Search_by_Equipment Name");
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		
			
		}
		
		@Test(enabled = true,priority = 4)
		public void SearchbyApplicableChecklist() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@ref='eMenu'])[5]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("pre");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
			Thread.sleep(2000);
			ts.takePageScreenshot_onPass(driver, "Search by Applicable Check list");
			Reporter.log("Search_by_Applicable Check list");
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		    Thread.sleep(2000);
			
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
	}
	@Test(priority=6,dataProvider="updateequipdp",enabled=true)
	public void updateequipment(String tc,String equipmentname,String func,String prefun) throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(equipmentname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='6']//img[@alt='edit'])")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("EquipmentName")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		driver.findElement(By.id("EquipmentName")).sendKeys("GITL Test equipement99");
		 if(func.contains("yes"))
		    {
		    driver.findElement(By.id("EquipApplicableChecklist")).click();
		    }
		    Thread.sleep(1000);
		    if(prefun.contains("yes"))
		    {
		    driver.findElement(By.xpath("(//input[@id=\'EquipApplicableChecklist\'])[2]")).click();
		    }
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//input[@name=\'DeleteIndication\']")).click();
		    Thread.sleep(1000);
		    Thread.sleep(500);
			ts.takePageScreenshot_onPass(driver, tc+"pic1");
			Thread.sleep(500);
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
		    Thread.sleep(1000);
		    try {
				driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
			} catch (Exception e1) {
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
		   // driver.navigate().refresh();
		    driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("J");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.ENTER);
	}
	
	@Test(priority=7,dataProvider="deleteequipdp",enabled=true)
	public void deleteequipment(String tc,String equipmentname) throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(equipmentname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='6']//img[@alt='delete'])")).click();
		Thread.sleep(2000);
		Thread.sleep(1000);
	    try {
	    	Thread.sleep(500);
			ts.takePageScreenshot_onPass(driver, tc+"pic1");
			Thread.sleep(500);
			driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		} catch (Exception e1) {
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
	   // driver.navigate().refresh();
	    driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("J");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.ENTER);
	}
	@DataProvider
	  public Object[][] addequipdp() {
	    return new Object[][] {
//	    	 new Object[] { "blank equipement","Electrical","","no","yes" }, 
//	    	 new Object[] { "Duplicate equipement","Electrical","Equipment_003","no","yes" },
//	    	 new Object[] { "reset data","Electrical","reset data","no","no" },
	    	 new Object[] { "valid equipement","Electrical","Automation ep3","yes","no" },
	    	// new Object[] { "valid equipement max char","Mechanaical","Automation equipement2Automation equipement2Automation equipement2Automation equipement2Automation equipement2","yes","yes" }, 
//	    	
	    };
	  }
	@Test(priority=8,enabled=true)
	public void viewequipment_excel() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("equip00011");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='6']//img[@alt='view'])")).click();
		Thread.sleep(2000);
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "view equipment");
		Thread.sleep(500);
		 try {
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		driver.findElement(By.xpath("//*[@class='action-download']")).click();
		Thread.sleep(4000);
		//driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("J");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='action-download']")).click();
		Thread.sleep(5000);
		
	}
	 @Test(enabled=true, priority=9)
	  public void sorting() throws InterruptedException {
		  driver.findElement(By.xpath("//span[text()='Status']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Status SortingAscending");
		  Thread.sleep(3000);
		  Actions act=new Actions(driver);
//		  act. click(driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.ag-theme-alpine.d-none.d-md-block.d-lg-block > div > div > div.ag-root-wrapper-body.ag-focus-managed.ag-layout-normal > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-header.ag-pivot-off > div.ag-header-viewport > div > div > div:nth-child(1) > div.ag-header-cell-comp-wrapper > div > div > span.ag-sort-indicator-container > span.ag-sort-indicator-icon.ag-sort-ascending-icon > span")));
//		  act.build().perform();
		  driver.findElement(By.xpath("//span[text()='Status']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Status SortingDecending");
		  Reporter.log("<h2>Sorting by Status</h2>");
		  driver.findElement(By.xpath("//span[text()='Service Name']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"ServiceName SortingAscending");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//span[text()='Service Name']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"ServiceName SortingDecending");
		  Thread.sleep(3000);
		  Reporter.log("<h2>Sorting by Service Name</h2>");
		  driver.findElement(By.xpath("//span[text()='Equipment Code']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Equipment Code SortingAscending");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//span[text()='Equipment Code']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Equipment Code SortingDecending");
		  Thread.sleep(3000);
		  Reporter.log("<h2>Sorting by Equipment Code</h2>");
		  driver.findElement(By.xpath("//span[text()='Equipment Name']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Equipment Name SortingAscending");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//span[text()='Equipment Name']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Equipment Name SortingDecending");
		  Thread.sleep(3000);
		  Reporter.log("<h2>Sorting by Equipment Name</h2>");
		  driver.findElement(By.xpath("//span[text()='Applicable Checklist']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Applicable Checklist SortingAscending");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//span[text()='Applicable Checklist']")).click();
		  Thread.sleep(2000);
		  ts.takePageScreenshot_onPass(driver,"Applicable Checklist SortingDecending");
		  Thread.sleep(3000);
		  Reporter.log("<h2>Sorting by Applicable Checklist</h2>");	
		  

	  }
	@DataProvider
	  public Object[][] updateequipdp() {
	    return new Object[][] {
	    	
	    	 new Object[] { "update valid equipement","Automation equipement1","yes","yes" },
	    	 
//	    	
	    };
	  }
	
	@DataProvider
	  public Object[][] deleteequipdp() {
	    return new Object[][] {
	    	
	    	 new Object[] { "delete valid equipement1","Automation equipement" },
	    	 new Object[] { "delete valid equipement2","GITL" },
	    	 
//	    	
	    };
	  }
}



