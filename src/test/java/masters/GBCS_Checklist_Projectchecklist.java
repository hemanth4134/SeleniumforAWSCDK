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
public class GBCS_Checklist_Projectchecklist {
String eqnm="Automation ep4";
String project="ep4";
//String project="july_aug";

String checklistnm="Automation ep4";
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
		
		//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
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


	LoginPage lp=new LoginPage();
		lp.valid_UserLogin(driver, "dsp", "Gitl@2022aa", "Dealer");
		Thread.sleep(3000);
		
		//driver.navigate().refresh();
	}
	@Test(priority = 1,enabled = true)
	public void add_new_checklist_tab1_mandatory() throws InterruptedException
	{
		
		driver.navigate().to("https://tnctrackertest.godrej.com/checklistmaster");
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add New Checklist']")).click();
		 Thread.sleep(2000);
		
		 driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		 ts.takePageScreenshot_onPass(driver, "add_new_checklist_tab1_mandatory");
		 Thread.sleep(1000);
	}
	@Test(priority = 2,enabled = true)
	public void add_equip_activity() throws InterruptedException
	{
		Actions act=new Actions(driver);
		driver.findElement(By.xpath("//label[text()='Checklist Name']")).click();
		 Thread.sleep(2000);	
		 driver.findElement(By.xpath("//input[@name='ChecklistName']")).sendKeys(checklistnm);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@value='Functional']")).click();
		 Thread.sleep(2000);
		
		 Select svnm=new Select(driver.findElement(By.xpath("//select[@name='ServiceCode']")));
		 svnm.selectByValue("SER00001");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@name='ServiceType']")).click();
		 Thread.sleep(2000);
		 
		 
		 driver.findElement(By.cssSelector("#checklistdetails > div:nth-child(1) > div > div:nth-child(8) > div > svg")).click();
		 Thread.sleep(2000);
		
		 driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(eqnm);
		 Thread.sleep(1000);
		 act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
		 	act.build().perform();
		 
		 	Thread.sleep(1000);
		 	
		 	 driver.findElement(By.xpath("//button[text()='Add']")).click();
		 	 Thread.sleep(2000);
		 	driver.findElement(By.xpath("//input[@value='Functional']")).click();
			 Thread.sleep(1000);
		 	 driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		 	Thread.sleep(1000);
		 	ts.takePageScreenshot_onPass(driver, "add_checklist_tab1");
		 	Thread.sleep(1000);
		 	 driver.findElement(By.xpath("//button[text()='OK']")).click();
		 	
	}
	@Test(priority = 3,enabled = true)
	public void tab2() throws InterruptedException
	{
		
	 driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
	 Thread.sleep(1000);
	 try {
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
	}
	 Thread.sleep(1000);
	 ts.takePageScreenshot_onPass(driver, "add_checklist_tab2");
	 Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@id='Floor'])[1]")).click();

	driver.findElement(By.xpath("(//input[@id='Area'])[1]")).click();
		
	driver.findElement(By.xpath("(//input[@id='Capacity'])[1]")).click();
	Thread.sleep(1000);
	 driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
	 Thread.sleep(1000);
	 try {
		 ts.takePageScreenshot_onPass(driver, "add_checklist_tab2_next");
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
	}
	 Thread.sleep(1000);
	}
	@Test(priority = 4,enabled = true)
	public void tab3() throws InterruptedException
	{
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "tab3 checklist");
		Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"parameterdetails\"]/div/div[2]/div/a")).click();	
	Thread.sleep(1000);
 driver.findElement(By.xpath("//input[@name='Parameter']")).sendKeys("automation param1");
 Thread.sleep(1000);
 driver.findElement(By.xpath("//button[text()='Add']")).click();
 Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	 	Thread.sleep(1000);
	 	ts.takePageScreenshot_onPass(driver, "add_checklist_tab3");
	 	Thread.sleep(1000);
	 	 driver.findElement(By.xpath("//button[text()='OK']")).click();
	}
	@Test(priority = 5,enabled = true)
	public void tab4() throws InterruptedException
	{
		driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
		 Thread.sleep(1000);
		 try {
			 ts.takePageScreenshot_onPass(driver, "add_checklist_tab3_next");
			 Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		 Thread.sleep(1000);
		
		 driver.findElement(By.xpath("//*[@id=\"statusdetails\"]/div/div[1]/div/a")).click();	
		 Thread.sleep(1000);
		
		 driver.findElement(By.xpath("//*[@name='Status']")).sendKeys("my status1");
		 driver.findElement(By.xpath("//*[@name='Remark']")).sendKeys("my remarks1");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Add']")).click();
		 Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			 Thread.sleep(2000);
			 ts.takePageScreenshot_onPass(driver, "add_checklist_tab4_next");
		 
	}
	@Test(priority = 6,enabled = true)
	public void tab5() throws InterruptedException
	{
		Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@id='Contractor'])[1]")).click();	
		 Thread.sleep(1000);
		 ts.takePageScreenshot_onPass(driver, "add_checklist_tab5");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		 	Thread.sleep(1000);
		 	ts.takePageScreenshot_onPass(driver, "add_checklist_tab5_pic2");
		 	
		 	 driver.findElement(By.xpath("//button[text()='OK']")).click();
		 	Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Freeze']")).click();	
		 Thread.sleep(1000);
		 ts.takePageScreenshot_onPass(driver, "add_checklist_tab5_pic3");
		 Thread.sleep(1000);
		 try {
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		 	Thread.sleep(1000);
		
	}
	@Test(priority = 7)
	public void add_equipment_toProject() throws InterruptedException
	{
		Actions act=new Actions(driver);
	driver.navigate().to("https://tnctrackertest.godrej.com/projectmaster");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys(project);
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//img[@alt='edit'])[1]")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[text()='4']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='projectservice']/div/div[2]/div/a")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.cssSelector("div > div > div > div:nth-child(2) > svg")).click();
	Thread.sleep(1000);

	act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
		act.build().perform();
		
		
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Add']")).click();
		 Thread.sleep(2000);
			act.click(driver.findElement(By.cssSelector("div:nth-child(3) > svg > path:nth-child(1)")));
			act.build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys(eqnm);
			Thread.sleep(1000);
		act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
			act.build().perform();
			
			
			Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='Add']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("(//div[@col-id='EquipmentTag'])[2]")).click();
			 driver.findElement(By.xpath("(//div[@col-id='EquipmentTag'])[2]")).click();
			 Thread.sleep(1000);
			 act.sendKeys(driver.findElement(By.xpath("(//div[@col-id='EquipmentTag'])[2]")), Keys.ENTER);
			 act.build().perform();
			 driver.findElement(By.xpath("(//input[@type='text' and @maxlength='200'])")).sendKeys(project);
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@type='text' and @maxlength='200']")).sendKeys(Keys.TAB);
			 act.build().perform();
			 driver.findElement(By.xpath("//input[@type='text' and @maxlength='200']")).sendKeys(project);
			 Thread.sleep(1000);
		
			 driver.findElement(By.xpath("//button[text()='Save']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='Update']")).click();
			 Thread.sleep(1000); 
			 ts.takePageScreenshot_onPass(driver, "automation ep1 pic2");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='OK']")).click();
		
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='Done']")).click();
			 Thread.sleep(1000);
	}
	@Test(priority = 8)
	public void project_checklist_selectproject() throws InterruptedException
	{
		Actions act=new Actions(driver);
		driver.navigate().to("https://tnctrackertest.godrej.com/projectchecklist");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#root > div > div.app-container > div.main-container.container-fluid > div.action-comp-container.container-fluid > div > div:nth-child(1) > div > svg")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys(project);
			Thread.sleep(1000);
		act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
			act.build().perform();		
			Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='Add']")).click();
			 Thread.sleep(3000);
		ts.takePageScreenshot_onPass(driver, "project checklist pic1");
	}
	@Test(priority = 9)
	public void update_revise_checklist() throws InterruptedException
	{
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		driver.navigate().to("https://tnctrackertest.godrej.com/checklistmaster");
		Thread.sleep(1000);
		
	 driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(checklistnm);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='edit'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Update Status']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "update_revise_checklist_tab1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
		 Thread.sleep(1000);
		 try {
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@id='Capacity'])[1]")).click();
			Thread.sleep(1000);
		 Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "update_revise_checklist_tab2");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
			 Thread.sleep(1000);
			 try {
				driver.findElement(By.xpath("//button[text()='OK']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
			 Thread.sleep(1000);
			 try {
				driver.findElement(By.xpath("//button[text()='OK']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();	
			 Thread.sleep(1000);
			 try {
				driver.findElement(By.xpath("//button[text()='OK']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			 	Thread.sleep(1000);
			 
			 	
			 	 try {
					driver.findElement(By.xpath("//button[text()='OK']")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			 	Thread.sleep(1000);
			// driver.findElement(By.xpath("//button[text()='Freeze']")).click();	
			 Thread.sleep(1000);
			 ts.takePageScreenshot_onPass(driver, "update_checklist_tab5_pic3");
			 Thread.sleep(1000);
			 try {
				driver.findElement(By.xpath("//button[text()='OK']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			 driver.findElement(By.xpath("//a[text()='Back to Checklist Master']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(checklistnm);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//img[@alt='edit'])[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[text()='New Version']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[text()='5']")).click();
			Thread.sleep(2000);
			 Thread.sleep(1000);
			 try {
				driver.findElement(By.xpath("//button[text()='OK']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block			
			}
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			 	Thread.sleep(1000);
			 
			 	
			 	 try {
					driver.findElement(By.xpath("//button[text()='OK']")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			 	Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Freeze']")).click();	
			 Thread.sleep(3000);
			
			 ts.takePageScreenshot_onPass(driver, "new_version_freezed");
			 Thread.sleep(1000);
			 try {
					driver.findElement(By.xpath("//button[text()='OK']")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[1]")).sendKeys(checklistnm);
				Thread.sleep(1000);
				 ts.takePageScreenshot_onPass(driver, "view all versions");
				 Thread.sleep(1000);
	}
	
	@Test(priority = 10)
	public void submit_functional_prefunctional_checklist() throws InterruptedException
	{
		Actions act=new Actions(driver);
		driver.navigate().to("https://tnctrackertest.godrej.com/projectchecklist");
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#root > div > div.app-container > div.main-container.container-fluid > div.action-comp-container.container-fluid > div > div:nth-child(1) > div > svg")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys(project);
			Thread.sleep(1000);
		act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
			act.build().perform();		
			Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='Add']")).click();
			 Thread.sleep(3000);
			 
		driver.findElement(By.xpath("(//img[@alt='statusFunimage'])[1]")).click();
		Thread.sleep(3000);
		 try {
				driver.findElement(By.xpath("//button[text()='Ok']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//select[@name='VersionCode']")).click();
		 Thread.sleep(3000);
		 ts.takePageScreenshot_onPass(driver, "versions dropdown");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[@name='VersionSubmit']")).click();
		 driver.findElement(By.xpath("//input[@id='Floor']")).sendKeys("101");
		 driver.findElement(By.xpath("//input[@id='Area']")).sendKeys("1000");
		
		 driver.findElement(By.xpath("//input[@id='Capacity']")).sendKeys("804");
		 Thread.sleep(1000);
	
		Select status=new Select(driver.findElement(By.xpath("//select[@id='Status']")));
		status.selectByIndex(1);
		 Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "project checklis pic1");
		Thread.sleep(1000);
		 act.click(driver.findElement(By.xpath("//div[text()='Project Checklist']")));
		 act.build().perform();
		 act.sendKeys(Keys.PAGE_DOWN);
		 act.build().perform();
		 Thread.sleep(2000);
		 
		driver.findElement(By.xpath("(//label[text()='Remarks'])[2]")).click();
		 act.sendKeys(Keys.ENTER);
		 act.build().perform();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@name='Remarks'])[2]")).sendKeys("my remarks");
		 Thread.sleep(3000);
		 try {
				driver.findElement(By.xpath("//button[text()='Ok']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		 try {
				driver.findElement(By.xpath("//button[text()='No']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		 try {
				driver.findElement(By.xpath("//button[text()='Ok']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		 driver.findElement(By.xpath("//label[text()='Contractor']")).click();
		 act.sendKeys(Keys.ENTER);
		 act.build().perform();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@name='Contractor']")).sendKeys("Tichkule and tichkule");
		 Thread.sleep(1000);
		 try {
				driver.findElement(By.xpath("//button[text()='Ok']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		 try {
				driver.findElement(By.xpath("//button[text()='No']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		 Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, "project checklis pic2");
			Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[@name='TempSave']")).click();
		 Thread.sleep(1000);
		 try {
			driver.findElement(By.xpath("//button[text()='Yes']")).click();
			} catch (Exception e1) {
			// TODO Auto-generated catch block
			}
		 ts.takePageScreenshot_onPass(driver, "project checklis pic3");
		 try {
				driver.findElement(By.xpath("//button[text()='Ok']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		
		
	}
	
	@Test(enabled = true,priority = 11)
	public void submitproject_chkandview() throws InterruptedException
	{
		Actions act=new Actions(driver);
		driver.navigate().to("https://tnctrackertest.godrej.com/projectchecklist");
		Thread.sleep(5000);
		 Thread.sleep(1000);
		
		 driver.findElement(By.cssSelector("#root > div > div.app-container > div.main-container.container-fluid > div.action-comp-container.container-fluid > div > div:nth-child(1) > div > svg")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@placeholder='Search here...'])[2]")).sendKeys(project);
			Thread.sleep(1000);
		act.click(driver.findElement(By.xpath("(//input[@id='selection0'])[1]")));
			act.build().perform();		
			Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[text()='Add']")).click();
			 Thread.sleep(3000);
			 
		driver.findElement(By.xpath("(//img[@alt='statusFunimage'])[1]")).click();
		Thread.sleep(3000);
		 try {
				driver.findElement(By.xpath("//button[text()='Ok']")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		 Thread.sleep(3000);
		 act.click(driver.findElement(By.xpath("//div[text()='Project Checklist']")));
		 act.build().perform();
		 act.sendKeys(Keys.PAGE_DOWN);
		 act.build().perform();
		 Thread.sleep(2000);
	
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[text()='Yes']")).click();
		 Thread.sleep(2000);
		 ts.takePageScreenshot_onPass(driver, "project submit pic1");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[text()='OK']")).click();
		 Thread.sleep(2000);
		 ts.takePageScreenshot_onPass(driver, "project submit pic2");
		 Thread.sleep(3000);
			driver.findElement(By.xpath("(//img[@alt='statusFunimage'])[1]")).click();
			Thread.sleep(3000);
			 try {
					driver.findElement(By.xpath("//button[text()='Ok']")).click();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			
			 Thread.sleep(3000);
				driver.findElement(By.xpath("//a[text()='Download Project Transaction Checklist']")).click();
				 Thread.sleep(2000);
				ts.takePageScreenshot_onPass(driver, "project submit pic3");
				 Thread.sleep(3000);
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
