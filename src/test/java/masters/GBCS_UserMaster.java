package masters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GBCS_UserMaster {
	WebDriver driver;
	GBCSTestScreenshots ts;
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tnctrackertest.godrej.com/usermaster");
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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("Inactive");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Search by user status");
		Reporter.log("Search_by_status");
		Thread.sleep(1000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
		Thread.sleep(500);
	}
	@Test(enabled = true,priority = 1)
	public void Searchbyusertype() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("user");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Searchbyuserstatus");
		Reporter.log("Searchbyuserstatus");
		Thread.sleep(2000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
		Thread.sleep(500);
	}
	@Test(enabled = true,priority = 2)
	public void Searchbyuserid() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("dsp");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Searchbyuserid");
		Reporter.log("Searchbyuserid");
		Thread.sleep(2000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
		Thread.sleep(500);
	}
	@Test(enabled = true,priority = 3)
	public void Searchbyusername() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("venkatesh");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Searchbyusername");
		Reporter.log("Searchbyusername");
		Thread.sleep(2000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
		Thread.sleep(500);
	}
	@Test(enabled = true,priority = 4)
	public void Searchbycompany() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("ga");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Searchbycompany");
		Reporter.log("Searchbycompany");
		Thread.sleep(2000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
		Thread.sleep(500);
	}
	@Test(enabled = true,priority = 5)
	public void Searchbyuserrole() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("a");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Searchbyuserrole");
		Reporter.log("Searchbyuserrole");
		Thread.sleep(1000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
		Thread.sleep(500);
	}
	@Test(enabled = true,priority = 6)
	public void Searchbyuserdesig() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@ref='eMenu'])[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("sd");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Searchbyuserdesig");
		Reporter.log("Searchbyuserdesig");
		Thread.sleep(1000);
	//	driver.findElement(By.cssSelector("#root > div > div > div > div.grid-comp-container.container-fluid > div.d-flex > div.filter-col.pr-0.me-2 > div > svg")).click();
	   driver.findElement(By.xpath("//button[text()='Clear All']")).click();
//		Thread.sleep(500);
//		ts.takePageScreenshot_onPass(driver, "search equip by status");
		Thread.sleep(500);
	}
	@Test(enabled = true,priority = 7,dataProvider = "adduser")
	public void adduser(String tc,String userid,String usnm,String company,String role,String desig,String email,String mob) throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Add New User']")).click();
		Thread.sleep(2000);
		if(tc.contains("valid employee"))
		{			
			driver.findElement(By.xpath("//input[@value='Employee']")).click();
		}
		else
		{
		driver.findElement(By.xpath("//input[@value='User']")).click();
		}
		driver.findElement(By.xpath("//input[@name='UserId']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@name='UserId']")).sendKeys(userid);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(usnm);	
		
		driver.findElement(By.cssSelector("#usermaster > div:nth-child(1) > div:nth-child(4) > div > div > svg")).click();
		Thread.sleep(1000);	
	    driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys(company);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//input[@name='selection'])[1]")).click();    
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
	   Thread.sleep(1000);
		driver.findElement(By.cssSelector("#usermaster > div:nth-child(1) > div:nth-child(5) > div > div > svg")).click();
		Thread.sleep(1000);	
	    driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys(role);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//input[@name='selection'])[1]")).click();
	    
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@name='Designation']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	   driver.findElement(By.xpath("//input[@name='Designation']")).sendKeys(desig);
	
	   Thread.sleep(1000);
	   if(!tc.contains("valid employee"))
	   {
	   driver.findElement(By.xpath("//input[@name='EmailId']")).sendKeys(email);
	   }
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@name='MobileNo']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	   driver.findElement(By.xpath("//input[@name='MobileNo']")).sendKeys(mob);
	   Thread.sleep(1000);
	   ts.takePageScreenshot_onPass(driver, tc+"pic1");
		
		  driver.findElement(By.xpath("(//button[text()='Add'])[1]")).click();
		  Thread.sleep(1000);
		  try {
			driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
		  ts.takePageScreenshot_onPass(driver, tc+"pic2");
		  Thread.sleep(1000);
		  try {
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			
		}
	    try {
	    	
	    	
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	    Thread.sleep(1000);
	}
	@Test(enabled = true,priority = 8)
	public void updateuser() throws InterruptedException
	{
		
	driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys("jarvis");
	
	
	Actions act=new Actions(driver);
	act.click(driver.findElement(By.xpath("(//div[text()='jarvis'])[1]")));
	act.build().perform();
	for(int i=1;i<10;i++)
	{
	act.sendKeys(Keys.ARROW_RIGHT);
	act.build().perform();
	Thread.sleep(500);
	}
	 Thread.sleep(1000);
	
driver.findElement(By.xpath("(//img[@alt='edit'])[1]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("jarvis update");	

driver.findElement(By.cssSelector("#usermaster > div:nth-child(1) > div:nth-child(4) > div > div > svg")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys("ga");
Thread.sleep(1000);
driver.findElement(By.xpath("(//input[@name='selection'])[1]")).click();    
Thread.sleep(1000);
driver.findElement(By.xpath("(//button[text()='Add'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.cssSelector("#usermaster > div:nth-child(1) > div:nth-child(5) > div > div > svg")).click();
Thread.sleep(1000);	
driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys("kt");
Thread.sleep(1000);
driver.findElement(By.xpath("(//input[@name='selection'])[1]")).click();

Thread.sleep(1000);
driver.findElement(By.xpath("(//button[text()='Add'])[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//input[@name='Designation']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
driver.findElement(By.xpath("//input[@name='Designation']")).sendKeys("new designation");

Thread.sleep(1000);
driver.findElement(By.xpath("//input[@name='EmailId']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
driver.findElement(By.xpath("//input[@name='EmailId']")).sendKeys("newmail@gmail.com");

Thread.sleep(1000);
driver.findElement(By.xpath("//input[@name='MobileNo']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
driver.findElement(By.xpath("//input[@name='MobileNo']")).sendKeys("+91 9664176927");
Thread.sleep(1000);
ts.takePageScreenshot_onPass(driver, "update pic1");

  driver.findElement(By.xpath("//button[text()='Update']")).click();
  Thread.sleep(1000);
  try {
	driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
	 
} catch (Exception e1) {
	// TODO Auto-generated catch block
}
  ts.takePageScreenshot_onPass(driver, "update pic2");
  Thread.sleep(1000);
  try {
	driver.findElement(By.xpath("//button[text()='OK']")).click();
} catch (Exception e2) {
	// TODO Auto-generated catch block
	
}
driver.navigate().refresh();
	}
	@Test(enabled = true,priority = 9,dataProvider = "deluserdp")
	public void deleteuser(String user) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).clear();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
	driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(user);
	
	
	Actions act=new Actions(driver);
	act.click(driver.findElement(By.xpath("(//div[contains(text(),'"+user+"')])[1]")));
	act.build().perform();
	for(int i=1;i<10;i++)
	{
	act.sendKeys(Keys.ARROW_RIGHT);
	act.build().perform();
	Thread.sleep(500);
	}
	 Thread.sleep(1000);
	
driver.findElement(By.xpath("(//img[@alt='delete'])[1]")).click();
Thread.sleep(2000);

driver.findElement(By.xpath("//button[text()='Delete']")).click();
Thread.sleep(500);
ts.takePageScreenshot_onPass(driver, user+"delete pic1");
Thread.sleep(1000);
try {
	driver.findElement(By.xpath("//button[text()='OK']")).click();
} catch (Exception e2) {
	// TODO Auto-generated catch block
	
}
driver.navigate().refresh();
	}
	@Test(priority=10,enabled=true)
	public void viewuser_excel() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).clear();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("dsp");
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.click(driver.findElement(By.xpath("(//div[text()='dsp'])[1]")));
		act.build().perform();
		for(int i=1;i<10;i++)
		{
		act.sendKeys(Keys.ARROW_RIGHT);
		act.build().perform();
		Thread.sleep(500);
		}
		 Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@aria-colindex='11']//img[@alt='view'])")).click();
		Thread.sleep(2000);
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "view user");
		Thread.sleep(500);
		 try {
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		driver.findElement(By.xpath("//*[@class='icon-border']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("J");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='icon-border']")).click();
		Thread.sleep(5000);
		
	}
	@DataProvider
	  public Object[][] adduser() {
	    return new Object[][] {
	      new Object[] { "blank useid","","username","bcd","sbm","test","abc@gmail.com","+91 9867037381" }, //search by id
	      new Object[] { "blank username","test1","","bcd","sbm","test","abc@gmail.com","+91 9867037381" }, 
	      new Object[] { "blank designation","test1","","bcd","sbm","","abc@gmail.com","+91 9867037381" }, 
	      new Object[] { "blank email","test1","test1","bcd","sbm","test","","+91 9867037381" }, 
	      new Object[] { "blank mobile","test1","test1","bcd","sbm","test","abc@gmail.com","" }, 
	      new Object[] { "inavlid mobile and email","test1","test1","bcd","sbm","test","gmail.com","12345" },
	      new Object[] { "duplicate user","dsp","test1","bcd","sbm","test","abc@gmail.com","+91 9867037381" }, 
	      new Object[] { "valid user","jarvis","jarvis","bcd","sbm","test","jarvis@gmail.com","+91 9867037381" }, 
	      new Object[] { "valid employee","leenak","Leena Kamble","bcd","sbm","test","leenak@godrej.com","+91 9867037382" }, 
	      new Object[] { "userid and username validation","userid-test.a_b_c_d_e_f_g_h_i_j-test.a_b_c_d_e_f_g_h_i_j-test.a_b_c_d_e_f_g_h_i_j","Test_MyuserN@m #test2 $test3 *test4 .-Test MyuserN@m #test2 $test3 *test4$test3 *test4$test3 *test7","bcd","sbm","test","useridname@gmail.com","+91 9867037381" }, 
	    };
	  }
	@DataProvider
	  public Object[][] deluserdp() {
		return new Object[][] {
		 new Object[] { "jarvis"},
			
			new Object[] { "leenak"},
			 new Object[] { "userid-test"},
		};
	}
}
