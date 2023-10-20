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
public class GBCS_ProjectMaster {
String projnm="automation_ep3";
String equipnm="Automation ep3";
	WebDriver driver;
	GBCSTestScreenshots ts;
	WebDriverWait wt;
	String empid="";
	int docid=2;
	int tab4record=2;
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
		driver.get("https://tnctrackertest.godrej.com/projectmaster");

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
		
		//driver.navigate().refresh();
	}
	//@Test(priority=0)
	public void search_projbystatus() throws InterruptedException {
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
			ts.takePageScreenshot_onPass(driver, "search_projbystatus");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	//@Test(priority=1)
	public void search_LOB() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by loc code </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[2]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("gbcs");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_LOB");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	@Test(priority=2)
	public void search_byprojcode() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by location </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[3]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("test111");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_byprojcode");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	//@Test(priority=3)
	public void search_byProjectname() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by location type </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("microsoft");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		try {
			ts.takePageScreenshot_onPass(driver, "search_byProjectname");
			//driver.switchTo().alert().accept();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		Thread.sleep(1000);
	}

	//@Test(priority=4)
	public void search_bycountry() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by location country </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[5]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("sri");
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
	//@Test(priority=5)
	public void search_bylocation() throws InterruptedException {
		Reporter.log("<h2> User story: Location Master search by location country </h2>");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[6]")).click();
		//driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Filter...'])[1]")).sendKeys("mumbai");
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
	//@Test(priority=6,dataProvider="globalsearchdp")
	public void globalsearch(String searchbycriteria) throws InterruptedException
	{
		//steps
		Reporter.log("<h2> User story: Project Master global search </h2>");
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
	@Test(priority=7,dataProvider="addproj")
	public void addProj_tab1(String tc,String status,String projcode,String projname,String projarea,String org_value,String revised_value) throws InterruptedException
	{
		//stepsString tc,String status,String projcode,String projname,String projarea,String org_value,String revised_value
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
	@Test(enabled=true,priority=8,dataProvider = "tab2dp")
	public void tab2(String doc,String file) throws InterruptedException
	{
		
		Thread.sleep(1000);
Actions act=new Actions(driver);
		Thread.sleep(1000);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search here...']")), "jarvis");
		act.build().perform();
		Thread.sleep(1000);
		act.click(driver.findElement(By.xpath("(//img[@alt='edit'])[1]")));
		act.build().perform();
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[text()='Order Documents']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//a[text()='Add New' and @class='blueColor'])[1]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//div[@col-id='DocumentName'])["+docid+"]")).click();
		 
		 driver.findElement(By.xpath("//input[@type='text' and @maxlength='200']")).sendKeys(doc);
		 driver.findElement(By.xpath("//input[@type='text' and @maxlength='200']")).sendKeys(Keys.TAB);
		 
		 try {
				driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys(file);
				Thread.sleep(5000);
				ts.takePageScreenshot_onPass(driver, "file upload"+doc);
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
 act.click(driver.findElement(By.xpath("//div[text()='Edit']")));
	act.build().perform();
	act.sendKeys(Keys.PAGE_DOWN);
	act.build().perform();
	Thread.sleep(1000);
	
	
	 driver.findElement(By.xpath("//button[text()='Save']")).click();
	 Thread.sleep(1000);
	
	 driver.findElement(By.xpath("//button[text()='Update']")).click();
	 Thread.sleep(1000);
	 ts.takePageScreenshot_onPass(driver, doc+"pic1");
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//button[text()='OK']")).click();
	 Thread.sleep(1000);
	 ts.takePageScreenshot_onPass(driver, doc+"pic2");
	 Thread.sleep(1000);
	 driver.navigate().refresh();
	  Thread.sleep(3000);
		 docid=docid+1;
		 
	}
	@Test(enabled=true,priority=9,dataProvider = "tab3dp")
	public void tab3(String stakeholder) throws InterruptedException
	{
		
		Thread.sleep(1000);
Actions act=new Actions(driver);
		Thread.sleep(1000);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search here...']")), "jarvis");
		act.build().perform();
		Thread.sleep(1000);
		act.click(driver.findElement(By.xpath("(//img[@alt='edit'])[1]")));
		act.build().perform();
		Thread.sleep(1000);
		
		act.click(driver.findElement(By.xpath("//span[text()='Team Members']")));
		act.build().perform();
		Thread.sleep(1000);
	act.click(driver.findElement(By.xpath("(//a[text()='Add New' and @class='blueColor'])[2]")));
	act.build().perform();
	Thread.sleep(1000);
	act.click(driver.findElement(By.cssSelector(".modalPopUpIcon > path:nth-child(2)")));
	act.build().perform();
	Thread.sleep(1000);
act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
	act.build().perform();
	
	act.click(driver.findElement(By.xpath("//*[text()='User Details']")));
	act.build().perform();
	act.sendKeys(Keys.PAGE_DOWN);
	act.build().perform();
	Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[text()='Add']")).click();
	 Thread.sleep(2000);
	 act.click(driver.findElement(By.xpath("//*[text()='Edit']")));
	act.build().perform();
	Thread.sleep(1000);
	act.sendKeys(Keys.PAGE_DOWN);
	act.build().perform();
	Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[text()='Save']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[text()='OK']")).click();
	 Thread.sleep(1000);
	 ts.takePageScreenshot_onPass(driver, stakeholder+"pic2");
	 Thread.sleep(1000);
	 driver.navigate().refresh();
	  Thread.sleep(3000);
	}
	@Test(enabled=true,priority=10,dataProvider = "tab4dp")
	public void tab4(String equipment) throws InterruptedException
	{
		
		Thread.sleep(1000);
Actions act=new Actions(driver);
		Thread.sleep(1000);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search here...']")), projnm);
		act.build().perform();
		Thread.sleep(1000);
		act.click(driver.findElement(By.xpath("(//img[@alt='edit'])[1]")));
		act.build().perform();
		Thread.sleep(1000);
		
		act.click(driver.findElement(By.xpath("//span[text()='4']")));
		act.build().perform();
		Thread.sleep(1000);
	act.click(driver.findElement(By.xpath("//*[@id='projectservice']/div/div[2]/div/a")));
	act.build().perform();
	Thread.sleep(1000);
	act.click(driver.findElement(By.cssSelector("div > div > div > div:nth-child(2) > svg > path:nth-child(2)")));
	act.build().perform();
	Thread.sleep(1000);
act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
	act.build().perform();
	
	
	Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[text()='Add']")).click();
	 Thread.sleep(2000);
	 Thread.sleep(1000);
		act.click(driver.findElement(By.cssSelector("div:nth-child(3) > svg > path:nth-child(1)")));
		act.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys(equipnm);
		Thread.sleep(1000);
	act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
		act.build().perform();
		
		
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Add']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//div[@col-id='EquipmentTag'])["+tab4record+"]")).click();
		 driver.findElement(By.xpath("(//div[@col-id='EquipmentTag'])["+tab4record+"]")).click();
		 Thread.sleep(1000);
		 act.sendKeys(driver.findElement(By.xpath("(//div[@col-id='EquipmentTag'])["+tab4record+"]")), Keys.ENTER);
		 act.build().perform();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type='text' and @maxlength='200'])")).sendKeys("abc");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type='text' and @maxlength='200']")).sendKeys(Keys.TAB);
		 act.build().perform();
		 driver.findElement(By.xpath("//input[@type='text' and @maxlength='200']")).sendKeys("abc@gmail.com");
		 Thread.sleep(1000);
		 ts.takePageScreenshot_onPass(driver, equipment+"pic1");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Save']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Update']")).click();
		 Thread.sleep(1000); 
		 ts.takePageScreenshot_onPass(driver, equipment+"pic2");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='OK']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Done']")).click();
		 Thread.sleep(1000);
		 tab4record=tab4record+1;
	}
	  @Test(enabled=true,priority=11)
	  public void updateproj() throws InterruptedException
	  {
		  //steps to update
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		  driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("jarvis");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@aria-colindex='15']//img[@alt='edit'])")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "view tab1");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Order Documents']")).click();
			 Thread.sleep(1000);
			 
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[3]/div[1]/div/div/img[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			Thread.sleep(1000);
			 ts.takePageScreenshot_onPass(driver, "view tab2");
				Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Team Members']")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[3]/div/div[1]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[3]/div[2]/div/div/img")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "view tab3");
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			Thread.sleep(1000);
			Thread.sleep(1000);

	driver.findElement(By.xpath("//span[text()='4']")).click();
			Thread.sleep(1000);		
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[4]/div/div[1]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[3]/div/div/div/img")).click();
			Thread.sleep(1000);	
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			Thread.sleep(1000);
			
			ts.takePageScreenshot_onPass(driver, "view tab4");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			Thread.sleep(1000);
				driver.navigate().refresh();
				
	  }
	  @Test(enabled=true,priority=13,dataProvider="deleteprojdp")
	  public void deleteproj(String projname) throws InterruptedException
	  {
		  //steps to update
		  
			 Reporter.log("<h2> Project Master delete project</h2>");
			 driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
			  
			 driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(projname);
				Thread.sleep(2000);
				
			driver.findElement(By.xpath("(//div[@aria-colindex='15']//img[@alt='delete'])")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(1000);
				ts.takePageScreenshot_onPass(driver, projname+"pic1");
				Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
			Thread.sleep(1000);
				//ts.takePageScreenshot_onPass(driver, "Deleted"+locname);
				
		
				
			
					
				driver.navigate().refresh();
	  }
	  @Test(priority=12,enabled=true)
		public void viewproj_excel() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
			driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("jarvis");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@aria-colindex='15']//img[@alt='view'])")).click();
			Thread.sleep(2000);
			Thread.sleep(500);
			ts.takePageScreenshot_onPass(driver, "view tab1");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Order Documents']")).click();
			 Thread.sleep(1000);
			 ts.takePageScreenshot_onPass(driver, "view tab2");
				Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Team Members']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "view tab3");
			Thread.sleep(1000);

	driver.findElement(By.xpath("//span[text()='4']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "view tab4");
			Thread.sleep(1000);
			 
			 Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class='viewExcelLink']")).click();
			Thread.sleep(4000);
			
			try {
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			driver.navigate().refresh();
			Thread.sleep(1000);
		}
	  @Test(priority=14,enabled=true)
		public void sort_columns() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Project Status']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "status ascending");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Project Status']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "status descend");
			Thread.sleep(1000);		
			driver.findElement(By.xpath("//span[text()='Project Code']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "proj code ascending");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Project Code']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "proj code descend");
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
				
			driver.findElement(By.xpath("//span[text()='Project Name']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "Project Name ascending");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Project Name']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "Project Name descend");
			Thread.sleep(1000);
			
			
			driver.findElement(By.xpath("//span[text()='Start Date']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "Start Date ascending");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Start Date']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "Start Date descend");
			Thread.sleep(1000);
		}
	@DataProvider
	  public Object[][] globalsearchdp() {
	    return new Object[][] {
	    	
	    	new Object[] { "abc007" },  	
	    	new Object[] { "automation" },
	    	 new Object[] { "India" }, //search by country
	      new Object[] { "mumbai" },  //search by loc type
	      new Object[] { "09/05" },  //search by start date  
	      new Object[] { "20/05" },  //end date
	      
	     
	    };
	  }
	
	@DataProvider
	  public Object[][] addproj() {
	    return new Object[][] {
	    	
//	    	 new Object[] { "duplicate project","active","test","test","1000","20000","30000" }, 
//	    	new Object[] { "blank project","active","","test","1000","20000","30000" }, 
//	    	new Object[] { "max character project","active","test123456790123456","Project max char 12 $%^()-_.@{}Project max char 12 $%^()-_.@{}Project max char 12 $%^()-_.@{}Project max char 12 $%^()-_.@{}","1000","20000","30000" }, 
	    	 new Object[] { "valid project","active","automation_ep3","automation_ep3","1000","20000","30000" }, 
	    	
	  
	    };
	  }
	@DataProvider
	  public Object[][] tab2dp() {
	    return new Object[][] {

			new Object[] { "pdf uploads in tab2","C:\\Users\\vparab\\Documents\\Tab3 files\\Passed_TCs.pdf"},  
			new Object[] { "xlsx uploads in tab2","C:\\Users\\vparab\\Documents\\Tab3 files\\All fields validation.xlsx"},  
			new Object[] { "docx uploads in tab2","C:\\Users\\vparab\\Documents\\Tab3 files\\TQ Sheet.docx"},  
			new Object[] { "pptx uploads in tab2","C:\\Users\\vparab\\Documents\\Tab3 files\\Test Automation.pptx"},  
			new Object[] { "jpg uploads in tab2","C:\\Users\\vparab\\Documents\\Tab3 files\\dp.jpg"},  
			new Object[] { "png uploads in tab2","C:\\Users\\vparab\\Documents\\Tab3 files\\blank screen domicile.png"},  
	    };
	  }
	@DataProvider
	  public Object[][] tab3dp() {
	    return new Object[][] {
	    	 new Object[] { "tc1" }, //tc1
	    	 new Object[] { "tc2" }, //tc2
	    	 new Object[] { "tc3" }, //tc3
	    	 new Object[] { "tc4" }, //tc4
	   //   new Object[] { "tc2" },  //search by loc type
	  
	      
	     
	    };
	  }
	@DataProvider
	  public Object[][] tab4dp() {
	    return new Object[][] {
	    	 new Object[] { "tc1" }, //tc1
	    	
	      
	     
	    };
	  }
	@DataProvider
	  public Object[][] deleteprojdp() {
	    return new Object[][] {
	   // Object[] { "Mumbai" },  //linked location
	      new Object[] { "jarvis"}, //unlinked project
	      
	      new Object[] { "test123456790123456"}, // max character project
	     
	    };
	  }
	// @AfterClass
		public void afterClass() {
			driver.close();
		}
}
