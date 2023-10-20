package masters;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

public class GBCS_CompanyDivMaster {
	WebDriver driver;
	GBCSTestScreenshots ts;
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tnctrackertest.godrej.com/companydivisionmaster");
		driver.manage().window().maximize();
		ts=new GBCSTestScreenshots();
		Thread.sleep(3000);
		LoginPage lp=new LoginPage();
		lp.valid_UserLogin(driver,"dsp","Gitl@2022bb","user");
	}
	@Test(priority = 1,enabled = true)
	  public void SearchByStatus() throws Exception {
		  By Opt1=By.xpath("(//span[@class=\"ag-icon ag-icon-menu\"])[1]");
		  By Arrow1=By.xpath("(//span[@class='ag-icon ag-icon-small-down'])[1]");
		  By FilterText=By.id("ag-35-input");
		  By AndRadioButton=By.xpath("(//input[@type='radio'])[1]");
		  By FilterText2=By.xpath("(//input[@ref='eInput'])[14]");
		  By ApplyButton=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("//button[text()='Clear All']");
		  
		  Thread.sleep(3000);
		  driver.findElement(Opt1).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow1).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterText).sendKeys("in");
		  Thread.sleep(1000);
		  driver.findElement(AndRadioButton).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterText2).sendKeys("active");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "SearchedByStatus");
		  Reporter.log("Search_By_Status");
		  Thread.sleep(2000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(1000);
		  
	  }
	  
	  @Test(priority = 2,enabled = true)
	  public void SearchByCompanyDivisionCode() throws Exception 
	  {
		  
		  By Opt2 =By.xpath("(//span[@class=\"ag-icon ag-icon-menu\"])[2]");
		  By Arrow2=By.xpath("//span[@class='ag-icon ag-icon-small-down']");
		  By FilterTextNum=By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[1]");
		  By ApplyButton2=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("//button[text()='Clear All']");
		  
		  Thread.sleep(1000);
		  driver.findElement(Opt2).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow2).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterTextNum).sendKeys("020");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton2).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "SearchedByCompanyDivisionCode");
		  Reporter.log("Searched_ByCompany_DivisionCode");
		  Thread.sleep(1000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(2000);
	  }
	  
	  @Test(priority = 3,enabled = true)
	  public void SearchByCompanyDivisionName() throws Exception 
	  {
		  
		  By Opt3 =By.xpath("(//span[@class='ag-icon ag-icon-menu'])[3]");
		  By Arrow3=By.xpath("//span[@class='ag-icon ag-icon-small-down']");
		  By FilterTextName=By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[1]");
		  By ApplyButton3=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("//button[text()='Clear All']");
		  
		  Thread.sleep(2000);
		  driver.findElement(Opt3).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow3).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterTextName).sendKeys("Godrej ENE Division");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton3).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "SearchedByCompanyDivisionName");
		  Reporter.log("Searched_ByCompany_DivisionName");
		  Thread.sleep(1000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(2000);
	  }
	  
	  @Test(priority = 4,enabled = true)
	  public void SearchByLocationType() throws Exception 
	  {
		  
		  By Opt4 =By.xpath("(//span[@class='ag-icon ag-icon-menu'])[4]");
		  By Arrow4=By.xpath("//span[@class='ag-icon ag-icon-small-down']");
		  By FilterTextName=By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[1]");
		  By ApplyButton4=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("(//button[@type=\"button\"])[2]");
		  
		  Thread.sleep(2000);
		  driver.findElement(Opt4).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow4).click();
		  Thread.sleep(2000);
		  driver.findElement(FilterTextName).sendKeys("Overseas");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton4).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "SearchedByLocationType");
		  Reporter.log("Searched_ByLocationType");
		  Thread.sleep(1000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(2000);
	  }
	  
	//  @Test(priority = 5,enabled = true)
	  public void SearchByCountry() throws Exception 
	  {
		  
		  By Opt5 =By.xpath("(//span[@class='ag-icon ag-icon-menu'])[5]");
		  By Arrow5=By.xpath("//span[@class='ag-icon ag-icon-small-down']");
		  By FilterTextCountryName=By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[1]");
		  By ApplyButton5=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("//button[@class='ms-2 lh-1 clear-all-btn btn btn-outline-primary']");
		  
		  Thread.sleep(2000);
		  driver.findElement(Opt5).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow5).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterTextCountryName).sendKeys("sri lanka");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton5).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "SearchedByCountry");
		  Reporter.log("Searched_ByCountry");
		  Thread.sleep(1000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(2000);
	  }
	  
	//  @Test(priority = 6,enabled = true)
	  public void SearchByHoAddress() throws Exception 
	  {
		  
		  By Opt6 =By.xpath("(//span[@class='ag-icon ag-icon-menu'])[6]");
		  By Arrow6=By.xpath("//span[@class='ag-icon ag-icon-small-down']");
		  By FilterTextHoAddress=By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[1]");
		  By ApplyButton6=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("//button[@class='ms-2 lh-1 clear-all-btn btn btn-outline-primary']");
		  
		  Thread.sleep(2000);
		  driver.findElement(Opt6).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow6).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterTextHoAddress).sendKeys("abc");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton6).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "SearchedByHoAddress");
		  Reporter.log("Searched_ByHoAddress");
		  Thread.sleep(1000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(2000);
	  }
	  
	//  @Test(priority = 7,enabled = true)
	  public void SearchByWebsiteAddress() throws Exception 
	  {
		  
		  By Opt7 =By.xpath("(//span[@class='ag-icon ag-icon-menu'])[7]");
		  By Arrow7=By.xpath("//span[@class='ag-icon ag-icon-small-down']");
		  By FilterTextWebsiteAddress=By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[1]");
		  By ApplyButton7=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("//button[@class='ms-2 lh-1 clear-all-btn btn btn-outline-primary']");
		  
		  Thread.sleep(2000);
		  driver.findElement(Opt7).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow7).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterTextWebsiteAddress).sendKeys("www.facebook@co.in");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton7).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "Searched_ByWebsiteAddress");
		  Reporter.log("Searched_ByWebsiteAddress");
		  Thread.sleep(1000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(2000);
	  }
	  
	//  @Test(priority = 8,enabled = true)
	  public void SearchBySector() throws Exception 
	  {
		  
		  By Opt8 =By.xpath("(//span[@class='ag-icon ag-icon-menu'])[8]");
		  By Arrow8=By.xpath("//span[@class='ag-icon ag-icon-small-down']");
		  By FilterSectorName=By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[1]");
		  By ApplyButton7=By.xpath("//button[@type='submit']");
		  By ClearAll=By.xpath("//button[@class='ms-2 lh-1 clear-all-btn btn btn-outline-primary']");
		  
		  
		 
		  Thread.sleep(2000);
		  driver.findElement(Opt8).click();
		  Thread.sleep(1000);
		  driver.findElement(Arrow8).click();
		  Thread.sleep(1000);
		  driver.findElement(FilterSectorName).sendKeys("Sector 1");
		  Thread.sleep(1000);
		  driver.findElement(ApplyButton7).click();
		  Thread.sleep(1000);
		  ts.takePageScreenshot_onPass(driver, "Searched_BySector");
		  Reporter.log("Searched_BySector");
		  Thread.sleep(1000);
		  driver.findElement(ClearAll).click();
		  Thread.sleep(2000);
	  }
	//@Test(priority=9,dataProvider="addcompdp",enabled=true)
	public void addCompanyDiv(String tc,String companyname,String loctype,String country,String hoaddr,String tel,String webaddr) throws InterruptedException
	{
		 driver.findElement(By.xpath("//span[text()='Add New Company / Division']")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("CompanyName")).sendKeys(companyname);
		    
		    Thread.sleep(1000);

		if(loctype.contains("overseas"))
		{
			
		 driver.findElement(By.xpath("//input[@value='India']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Overseas']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#companydivisionmaster > div.row-fields.row > div:nth-child(1) > div > div > svg")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@placeholder='Search here...'])[2]")).sendKeys(country);
		
		
		driver.findElement(By.xpath("//span[contains(text(),'"+country+"')]//preceding::input[1]")).click();
		Thread.sleep(1000);
		
	   driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
		Thread.sleep(1000);
		}
		
		driver.findElement(By.id("CompanyHOAddress")).sendKeys(hoaddr);
		driver.findElement(By.id("CompanyTelephoneNo")).sendKeys(tel);
		
		driver.findElement(By.id("CompanyWebsiteAddress")).sendKeys(webaddr);
		
		Select selsector=new Select(driver.findElement(By.id("CompanySectorCode")));
		selsector.selectByVisibleText("Industrial");
//		driver.findElement(By.id("CompanySectorCode")).click();
//		{
//		driver.findElement(By.xpath("//option[. = 'Industrial']")).click();  
//		}
		Thread.sleep(1000);
		
		 driver.findElement(By.xpath("//input[@name='DeleteIndication']")).click();
		 Thread.sleep(1000);	
		
		 ts.takePageScreenshot_onPass(driver, tc+"pic1");
		 Thread.sleep(1000);
		 if(tc.equals("overseas company reset"))
		 {
			 Thread.sleep(1000);		
			 ts.takePageScreenshot_onPass(driver, tc+"before reset");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='Reset Fields']")).click();
			 Thread.sleep(1000);
			 Thread.sleep(1000);		
			 ts.takePageScreenshot_onPass(driver, tc+"after reset");
			 Thread.sleep(1000);
		 }
		 else
		 {
		 driver.findElement(By.xpath("//button[text()='Add']")).click();	
		 }
		 try {
			Thread.sleep(1000);		
			 ts.takePageScreenshot_onPass(driver, tc+"confirmation pic");
		} catch (InterruptedException e3) {
			
		}
		 Thread.sleep(1000);
		 try {
			driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			
		} catch (Exception e2) {
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
	//@Test(priority=10,enabled=true)
	public void updatecompany() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("test oversea");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='9']//img[@alt='edit'])")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("CompanyName")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		driver.findElement(By.id("CompanyName")).sendKeys("Updated test automation1");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//input[@name=\'DeleteIndication\']")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("CompanyHOAddress")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		    driver.findElement(By.id("CompanyHOAddress")).sendKeys("Plant 19A, Pirojshanagar, Godrej & Boyce Industry Estate, Vikhroli West, Mumbai");
		    driver.findElement(By.id("CompanyTelephoneNo")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		    driver.findElement(By.id("CompanyTelephoneNo")).sendKeys("+91 9867037381");
		    driver.findElement(By.id("CompanyWebsiteAddress")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
			driver.findElement(By.id("CompanyWebsiteAddress")).sendKeys("facebook1@test.com");
			
//			Select selsector=new Select(driver.findElement(By.id("CompanySectorCode")));
//			selsector.selectbyvisibletext();
			Thread.sleep(1000);
			driver.findElement(By.id("CompanySectorCode")).click();
			{
			driver.findElement(By.xpath("//option[. = 'Industrial']")).click();  
			}
		    Thread.sleep(500);
			ts.takePageScreenshot_onPass(driver, "updated company pic1");
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
				ts.takePageScreenshot_onPass(driver, "update company pic2");
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
			Thread.sleep(3000);
	}
	//@Test(priority=11,dataProvider="deletecompdp",enabled=true)
	public void deletecompany(String tc,String companyname) throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(companyname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='9']//img[@alt='delete'])")).click();
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
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("J");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	 //   driver.navigate().refresh();
		
	}
	@DataProvider
	  public Object[][] addcompdp() {
	    return new Object[][] {
	    	 new Object[] { "blank company","","India","India","abc-/@ ({})[]","+91 9123","face@book.com"}, 
	    	new Object[] { "blank address","Automation company1","India","India","","+91 9123","face@book.com"},
	    	new Object[] { "blank telephone","Automation company1","India","India","abc-/@ ({})[]","","face@book.com"},
	    	new Object[] { "invalid telephone","Automation company1","India","India","abc-/@ ({})[]","9702544386","face@book.com"},
	    	new Object[] { "blank website","Automation company1","India","India","abc-/@ ({})[]","+91 9702544386",""},
	    	 new Object[] { "duplicate company","test2","India","India","abc12, -/@ ({})[]","+91 9123","face@book.com"}, 
	    	// new Object[] { "duplicate webaddress","Automation company1","India","India","abc12, -/@ ({})[]","+91 9702544386","abc@gmail.com"}, 
	    	 new Object[] { "duplicate telephone","Automation company1","India","India","abc12, -/@ ({})[]","+5 9987","abc5@gmail.com"}, 
	    	 new Object[] { "overseas company reset","Test oversea","overseas","Sri","abc12, -/@ ({})[]","+91 9123","face@book.com"}, 
	    	 new Object[] { "overseas company","Test oversea","overseas","Sri","abc12, -/@ ({})[]","+91 9867037383","https://jarvis.com"}, 
	    };
	  }
	//@Test(priority=12,enabled=true)
	public void viewcompnay_excel() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@aria-colindex='9']//img[@alt='view'])")).click();
		Thread.sleep(2000);
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "view company");
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
	//@Test(priority = 13,enabled=true)
	public void SortBycols() throws Exception {
		driver.findElement(By.xpath("//span[text()='Status']")).click();
		ts.takePageScreenshot_onPass(driver, "StatusAscending_Order");
		Reporter.log("StatusAscending_Order");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Status']")).click();
		ts.takePageScreenshot_onPass(driver, "StatussDescending_Order");
		Reporter.log("StatussDescending_Order");
		Thread.sleep(1000);
		
        driver.findElement(By.xpath("//span[text()='Company / Division Code']")).click();
		ts.takePageScreenshot_onPass(driver, "CompanyDivisionCodeAscending_Order");
		Reporter.log("CompanyDivisionCodeAscending_Order");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Company / Division Code']")).click();
		ts.takePageScreenshot_onPass(driver, "CompanyDivisionCodeDescending_Order");
		Reporter.log("CompanyDivisionCodeDescending_Order");
		Thread.sleep(1500);
	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Company / Division Name']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "CompanyDivisionNameAscending_Order");
		Reporter.log("CompanyDivisionNameAscending_Order");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Company / Division Name']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "CompanyDivisionNameDescending_Order");
		Reporter.log("CompanyDivisionNameDescending_Order");
		Thread.sleep(400);
	
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Location Type']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "LocationTypeAscending_Order");
		Reporter.log("LocationTypeAscending_Order");
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//span[text()='Location Type']")).click();
		ts.takePageScreenshot_onPass(driver, "LocationTypeDescending_Order");
		Reporter.log("LocationTypeDescending_Order");
		
		Thread.sleep(400);
	
		Thread.sleep(400);
		driver.findElement(By.xpath("//span[text()='Country']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Ascending_Order");
		Reporter.log("CountryAscending_Order");
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Country']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "DCountryDescending_Order");
		Reporter.log("CountryDescending_Order");
		Thread.sleep(400);
	
		Thread.sleep(400);
		driver.findElement(By.xpath("//span[text()='HO Address']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "HomeAddressAscending_Order");
		Reporter.log("HomeAddressAscending_Order");
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='HO Address']")).click();
		Thread.sleep(1500);
		ts.takePageScreenshot_onPass(driver, "HomeAddressDescending_Order");
		Reporter.log("HomeAddressDescending_Order");
		Thread.sleep(400);
	
		Thread.sleep(400);
		driver.findElement(By.xpath("//span[text()='Website Address']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "WebSiteAddressAscending_Order");
		Reporter.log("WebSiteAddressAscending_Order");
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Website Address']")).click();
		Thread.sleep(700);
		ts.takePageScreenshot_onPass(driver, "WebSiteAddressDescending_Order");
		Reporter.log("WebSiteAddressDescending_Order");
		Thread.sleep(1500);
	
		Thread.sleep(400);
		driver.findElement(By.xpath("//span[text()='Sector']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "SectorAscending_Order");
		Reporter.log("SectorAscending_Order");
		driver.findElement(By.xpath("//span[text()='Sector']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "SectorDescending_Order");
		Reporter.log("SectorDescending_Order");
		Thread.sleep(1000);
	}
	@DataProvider
	  public Object[][] updateequipdp() {
	    return new Object[][] {
	    	
	    	 new Object[] { "update valid equipement","Automation equipement1","yes","yes" },
	    	 
//	    	
	    };
	  }
	
	@DataProvider
	  public Object[][] deletecompdp() {
	    return new Object[][] {
	    	
	    	 new Object[] { "delete valid company1","Updated test automation1" },
	    	// new Object[] { "delete valid company1","GITL" },
	    	 
//	    	
	    };
	  }
}



