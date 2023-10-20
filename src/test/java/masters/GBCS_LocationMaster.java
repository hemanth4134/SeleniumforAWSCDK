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
public class GBCS_LocationMaster {

	WebDriver driver;
	GBCSTestScreenshots ts;
	WebDriverWait wt;
	String empid="";
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.edge.driver", "./Browsers/msedgedriver.exe");
//		driver = new EdgeDriver();
		wt=new WebDriverWait(driver, Duration.ofSeconds(10));
		  js = (JavascriptExecutor)driver;	
		driver.get("https://tnctrackertest.godrej.com/locationmaster");

		driver.manage().window().maximize();
		Thread.sleep(4000);

		ts=new GBCSTestScreenshots();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='Login']")).click();
//	
	LoginPage lp=new LoginPage();
		lp.valid_UserLogin(driver, "dsp", "Gitl@2022aa", "Dealer");
		Thread.sleep(3000);
		//driver.navigate().refresh();
	}
	@Test(priority=0)
	public void search_locbystatus() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by status </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[1]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("Active");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_locbystatus");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	@Test(priority=1)
	public void search_locbynumber() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by loc code </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[2]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("25");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_locbynumber");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	@Test(priority=2)
	public void search_bylocation() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by location </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("abc");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_bylocation");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	@Test(priority=3)
	public void search_bylocationtype() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by location type </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[3]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("India");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_bylocationtype");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	@Test(priority=4)
	public void search_bycountry() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by location country </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[5]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("India");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_bylocationtype");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	@Test(priority=5,dataProvider="globalsearchdp")
	public void globalsearch(String searchbycriteria) throws InterruptedException
	{
		//steps
		Reporter.log("<h2> User story: Location Master global search </h2>");
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//input[@placeholder='Search...']")).click();
		Actions act=new Actions(driver);
		
		Thread.sleep(1000);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search here...']")), searchbycriteria);
		act.build().perform();
		ts.takePageScreenshot_onPass(driver, searchbycriteria);
		Thread.sleep(1000);
		driver.navigate().refresh();
		
	}
	@Test(priority=7,dataProvider="addlocdp")
	public void addLocation(String tc,String location,String country) throws InterruptedException
	{
		//steps
		Reporter.log("<h2> User story: Location Master Add "+tc+" </h2>");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//span[text()='Add New Location'])[1]")).click();
		try {
			driver.findElement(By.xpath("(//span[text()='Add New Location'])[1]")).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Reset Fields']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='Location']")).sendKeys(location);
		Thread.sleep(1000);

		//Select loclistdrp=new Select(driver.findElement(By.xpath("//select[@placeholder='Enter Location Type']")));
		if(tc.contains("invalid Country name"))
		{
			
			driver.findElement(By.xpath("//input[@type='radio' and @value='Overseas']")).click();
			driver.findElement(By.xpath("//input[@name='Country']")).sendKeys("India");
		}
		
		else if(tc.contains("valid location2"))
		{
			driver.findElement(By.xpath("//input[@type='radio' and @value='Overseas']")).click();
			driver.findElement(By.xpath("//input[@name='Country']")).sendKeys(country);
		}
		else
		{
			driver.findElement(By.xpath("//input[@type='radio' and @value='India']")).click();
			driver.findElement(By.xpath("//input[@name='Country']")).sendKeys(country);
		}
		
		Thread.sleep(1000);
		
		ts.takePageScreenshot_onPass(driver, "location "+tc);
		Thread.sleep(1000);
		if(tc.equals("reset location"))
		{
			driver.findElement(By.xpath("//button[text()='Reset Fields']")).click();
			 Thread.sleep(1000);
					
			 ts.takePageScreenshot_onPass(driver, tc+"after reset");
			 Thread.sleep(1000);
		}
		else
		{
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		}
		Thread.sleep(2000);
		if(tc.contains("Duplicate location"))
		{
			ts.takePageScreenshot_onPass(driver, "duplicate location");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
			Thread.sleep(1000);
		}
		else
		{
		try {
			
			driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc+"pic2");
			Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, tc+"pic3");
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		}
     try {
			driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		} catch (Exception e) {
			
		}
		Thread.sleep(1000);
		
	}
	  @Test(enabled=true,priority=8)
	  public void updateloc() throws InterruptedException
	  {
		  //steps to update
		 
			Reporter.log("<h2>  Updare record, positive/negative Tc's </h2>");
			 Reporter.log("<h2> User story: 123 Location Master </h2>");
			 Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
				driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("MH-Mulund");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@aria-colindex='6']//img[@alt='edit'])")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name='Location']")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
				driver.findElement(By.xpath("//input[@name='Location']")).sendKeys("Mulund-East");
				Thread.sleep(1000);
				Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, "update location pic1");
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
						ts.takePageScreenshot_onPass(driver, "update location pic2");
						Thread.sleep(500);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
					}
				driver.navigate().refresh();
				
	  }
	  @Test(enabled=true,priority=9,dataProvider="deletelocdp")
	  public void deleteloc(String locname) throws InterruptedException
	  {
		  //steps to update
		  try {
				driver.switchTo().alert().accept();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}
			
			 Reporter.log("<h2> Location Master delete location</h2>");
			 Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
				driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys(locname);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(1000);
				ts.takePageScreenshot_onPass(driver, locname+"pic1");
				Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
			Thread.sleep(1000);
				//ts.takePageScreenshot_onPass(driver, "Deleted"+locname);
				
		
				
			
					
				driver.navigate().refresh();
	  }
	  @Test(priority=10,enabled=true)
		public void viewloc_excel() throws InterruptedException
		{
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("bang");
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
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='action-download']")).click();
			Thread.sleep(5000);
			
		}
	  @Test(priority=11,enabled=true)
		public void sort_columns() throws InterruptedException
		{
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[text()='Status']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "status ascending");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Status']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "status descend");
			Thread.sleep(1000);
			
			
			driver.findElement(By.xpath("//span[text()='Location Code']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "loc code ascending");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Location Code']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "loc code descend");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//span[text()='Location']")).click();
			Thread.sleep(500);
			ts.takePageScreenshot_onPass(driver, "location ascending");
			Thread.sleep(500);
			driver.findElement(By.xpath("//span[text()='Location']")).click();
			Thread.sleep(500);
			ts.takePageScreenshot_onPass(driver, "location descend");
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//span[text()='Country']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "country ascending");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Country']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "country descend");
			Thread.sleep(1000);
		}
	@DataProvider
	  public Object[][] globalsearchdp() {
	    return new Object[][] {
	    	 new Object[] { "India" }, //search by country
	      new Object[] { "overseas" },  //search by loc type
	      new Object[] { "abc" },  //search by location
	    
	      
	     
	    };
	  }
	
	@DataProvider
	  public Object[][] addlocdp() {
	    return new Object[][] {
	    	 new Object[] { "blank location","","India" }, 
	    	// new Object[] { "invalid location name","Mumbai@Mahahrashtra","India" },
	    	// new Object[] { "invalid Country name","dubai","India" },
	    	 new Object[] { "Duplicate location","abc","India" },
	    	 new Object[] { "reset location","reset location","India" },
	    	 new Object[] { "valid location1","MH-Mulund","India" },
	    	 
	    	 new Object[] { "valid location2","The United states of America Log angeles texas miami newyork chicago north carolina south carolina halifax","The United states of America Log angeles texas miami newyork chicago north carolina south carolina halifax" }, 
	    	
	    };
	  }
	@DataProvider
	  public Object[][] deletelocdp() {
	    return new Object[][] {
	   // Object[] { "Mumbai" },  //linked location
	      new Object[] { "Mulund-East"},
	      new Object[] { "The United states of America Log angeles"},//unlinked location
	      
	     
	    };
	  }
	 @AfterClass
		public void afterClass() {
			driver.close();
		}
}
