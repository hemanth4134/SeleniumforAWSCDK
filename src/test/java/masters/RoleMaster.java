package masters;

import org.testng.annotations.Test;


import org.testng.annotations.DataProvider;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

public class RoleMaster {
	WebDriver driver;
	GBCSTestScreenshots ts;
	WebDriverWait wt;
	String empid="";
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		

		
//		System.setProperty("webdriver.edge.driver", "./Browsers/msedgedriver.exe");
//		driver = new EdgeDriver();
		wt=new WebDriverWait(driver, 40);
		  js = (JavascriptExecutor)driver;	
		driver.get("https://tnctrackertest.godrej.com/rolemaster");

		driver.manage().window().maximize();
		Thread.sleep(4000);

		ts=new GBCSTestScreenshots();
		Thread.sleep(1000);
		/*driver.findElement(By.xpath("//button[text()='Login']")).click();
//		LoginPage lp=new LoginPage();
//		lp.valid_DealerLogin(driver, "harshali", "@venGers100", "Dealer");
//		Thread.sleep(1000);*/
		
		LoginPage lp=new LoginPage();
		lp.valid_UserLogin(driver, "dsp", "Gitl@2022bb", "Dealer");
		
		//driver.navigate().refresh();
	}
		
	

	@Test(enabled = true,priority = 0)
	public void Searchbystatus() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("Inactive");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Search by status");
		Reporter.log("Search_by_status");
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[text()='Clear All']")).click();
	
		
	}
	@Test(enabled = true,priority = 1)
	public void SearchbyRolecode() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("abc");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Search by Rolecode");
		Reporter.log("Search_by_Rolecode");
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[text()='Clear All']")).click();
	
		
	}
	@Test(enabled = true,priority = 2)
	public void SearchbyRoleName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Search by RoleName");
		Reporter.log("Search_by_RoleName");
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[text()='Clear All']")).click();
	
		
	}
  @Test(dataProvider = "dp",priority=3,enabled=true)
  public void addRole(String tc, String role,String rolename) throws InterruptedException {
	    Reporter.log("<h2> User story Role Master & Authorization on Chrome Browser </h2>");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Add New Role']")).click();
		Thread.sleep(2000);
		//Reporter.log("<h2> User story:3 Role Master:Add Role Default Selection on Chrome Browser </h2>");
		ts.takePageScreenshot_onPass(driver, "Default Selection");
		Reporter.log("<h2> User story:3 Role Master & Authorization "+tc+"</h2>");

		
		driver.findElement(By.xpath("//*[@id='RoleCode']")).sendKeys(role);
		driver.findElement(By.xpath("//*[@id='RoleName']")).sendKeys(rolename);
		Thread.sleep(1000);
		if(tc.contains("reset field and cancel"))
		{
			Actions act=new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN);
			act.build().perform();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc+"before reset");
			driver.findElement(By.xpath("//button[text()='Reset Fields']")).click();	
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc+"after reset");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		}
		
		try {
			driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc+"pic1");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),'Add')])[2]")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc+"pic2");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),'Ok')])[1]")).click();
			ts.takePageScreenshot_onPass(driver, tc+"pic3");
		} catch (Exception e) {
		
		}
		
		try {
			
			driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		} catch (Exception e) {
			
		}
		driver.navigate().refresh();
		Thread.sleep(1000);
  }
  @Test(enabled = true,priority = 4)
	public void viewrecord() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("test");
		Thread.sleep(3000);
		ts.takePageScreenshot_onPass(driver, "Existing record");
		Reporter.log("view record");
		
	driver.findElement(By.xpath("(//img[@alt='view'])[1]")).click();
	Thread.sleep(1000);
	ts.takePageScreenshot_onPass(driver, "view record");
	Actions act=new Actions(driver);
	act.sendKeys(Keys.PAGE_DOWN);
	act.build().perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='Done']")).click();
		
  }
 // @Test(enabled = true,priority = 5)
	public void searchandEdit() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("test");
		Thread.sleep(3000);
		ts.takePageScreenshot_onPass(driver, "Existing record");
		Reporter.log("Existing record");
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//img[@alt='edit'])[1]"))));
		driver.findElement(By.xpath("(//img[@alt='edit'])[1]")).click();
		Thread.sleep(2000);
		ts.takePageScreenshot_onPass(driver, "Existing record pic01");
		Reporter.log("Existing_record pic01 ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='RoleName']")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='RoleName']")).sendKeys("Venkat@19");
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='DeleteIndication']"))));
		driver.findElement(By.xpath("//input[@name='DeleteIndication']")).click();
		
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='Display'])[2]"))));
		driver.findElement(By.xpath("(//*[@id='Display'])[2]")).click();
		
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='Add'])[2]"))));
		driver.findElement(By.xpath("(//*[@id='Add'])[2]")).click();
		
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='Modify'])[2]"))));
		driver.findElement(By.xpath("(//*[@id='Modify'])[2]")).click();
		
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='Delete'])[2]"))));
		driver.findElement(By.xpath("(//*[@id='Delete'])[2]")).click();	
		
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='Export'])[2]"))));
		driver.findElement(By.xpath("(//*[@id='Export'])[2]")).click();
		
		Actions aa = new Actions(driver);
		WebElement title = driver.findElement(By.xpath("//div[@class='modalTitle modal-title h4']"));
		aa.click(title);
		aa.build().perform();
		aa.sendKeys(Keys.PAGE_DOWN);
		aa.build().perform();
		
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Update']"))));
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		Thread.sleep(2000);
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//button[text()='Update'])[2]"))));
		driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
		Thread.sleep(3000);
		ts.takePageScreenshot_onPass(driver, "Existing record Updated");
		Reporter.log("Existing_record Updated");
		wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='OK']"))));
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
			
	
}
	//@Test(enabled = true,priority = 6,dataProvider = "deldp")
	public void searchandDelete(String tc,String role) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(role);
		Thread.sleep(3000);
		ts.takePageScreenshot_onPass(driver, "Updated record");
		Reporter.log("Updated record");
		try {
			wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//img[@alt='delete'])[1]"))));
			driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
			wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Delete']"))));
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			Thread.sleep(3000);
			ts.takePageScreenshot_onPass(driver, "Upadted record delete successfully"+role);
			Reporter.log("Upadted record delete successfully");	
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			driver.navigate().refresh();
			Thread.sleep(3000);
			ts.takePageScreenshot_onPass(driver, "After record delete successfully"+role);
			Reporter.log("After record delete successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}	
		
		
	}
	//@Test(priority=7,enabled=true)
	public void viewrole_excel() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("sbm");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='6']//img[@alt='view'])")).click();
		Thread.sleep(2000);
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "view role");
		Thread.sleep(500);
		 try {
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		driver.findElement(By.xpath("//*[@class='action-download']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("J");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='action-download']")).click();
		Thread.sleep(5000);
		
	}
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "blank role code and rolename","",""},
      new Object[] { "duplicate role code and rolename uppercase","ABC DEF","ABC DEF"},

     // new Object[] { "no checkbox select","testnine","testnine"},
      new Object[] { "special char valid role code and rolename","Godrej Engineer-123@#//(){]{]","Godrej Engineer-123@#//(){]{]"}, 
     // new Object[] { "valid role2","maxcharactertestmaxcharactertestmaxcharactertestmaxcharactertest","maxcharactertestmaxcharactertestmaxcharactertestmaxcharactertestmaxcharactertestmaxcharactertestmaxcharactertestmaxcharactertest"},
    //  new Object[] { "reset field and cancel","testnine","testnine"},
     
    };
  }
  @DataProvider
  public Object[][] deldp() {
    return new Object[][] {
      new Object[] { "unlinked role1","Godrej Engineer"},
      new Object[] { "unlinked role2","maxcharactertest"},
      
      new Object[] { "linked role","iuyteuelihoj"},
     
    };
  }
 // @AfterClass
	public void afterClass() {
		driver.close();
	}

}
