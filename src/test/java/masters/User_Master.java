package masters;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class User_Master {

	static WebDriver driver;
	GBCSTestScreenshots ts = new GBCSTestScreenshots();

	@BeforeTest
	public void BrowserOpen()

	{
		// Browser launching.
	//	System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Window maximize.
		driver.manage().window().maximize();
		driver.get("https://tnctrackertest.godrej.com");

	}

	@Test(priority = 1, dataProvider = "Login")
	public void loginToApp(String tc, String mail, String pwd) throws Exception {

		if (tc.equals("User Login")) {
			driver.findElement(By.xpath("(//input[@name='loginType'])[2]")).click();
			Thread.sleep(600);
			driver.findElement(By.name("userName")).sendKeys(mail);
			Thread.sleep(600);
			driver.findElement(By.name("password")).sendKeys(pwd);

			WebElement LoginButton = driver.findElement(By.xpath("//div//button[text()='Login']"));

			Actions act = new Actions(driver);
			act.moveToElement(LoginButton).click().build().perform();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[@class='sidebar-head']")).click();
			Thread.sleep(1000);
			WebElement AdminBtn = driver.findElement(By.xpath("//span[text()='Admin ']"));
			act.moveToElement(AdminBtn).click().build().perform();
			Thread.sleep(500);
			WebElement UserBtn = driver.findElement(By.xpath("//a[text()='User Master']"));
			act.moveToElement(UserBtn).click().build().perform();
		}

	}

	@Test(priority = 2, dataProvider = "AddEmployee")
	public void AddEmployee(String tc, String Cname, String UserID, String role, String mail, String UN, String design,
			String MobNo, String pwd) throws Exception {

		// new Object[] { "Valid Data","abc","SSR123","a" ,"sw@2023.gmail.com","SSR","QA
		// Engineer" ,"+91 23145678","Abcswa@12345"}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Add New User']")).click();
		Thread.sleep(300);
		Actions at = new Actions(driver);
		WebElement users = driver.findElement(By.xpath("(//input[@name='UserType'])[2]"));
		at.moveToElement(users).click().build().perform();
		
		WebElement check=driver.findElement(By.xpath("(//*[name()='svg'])[13]"));
		
		Thread.sleep(500);
		at.moveToElement(check).click().build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@name='selection'])[3]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
		Thread.sleep(500);
		
		if (tc.equals("Valid Data")) {

			try {
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(Cname);
				Thread.sleep(700);
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])[11]")).click();
				Thread.sleep(700);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				Thread.sleep(500);

			} catch (Exception f) {

			}

			driver.findElement(By.name("UserId")).click();
			Thread.sleep(500);
			driver.findElement(By.name("UserId")).sendKeys(UserID);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])//input[@name='selection']")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				;
				Thread.sleep(500);
			} catch (Exception ex) {

			}
			//driver.findElement(By.name("RoleName")).sendKeys(role);
			;
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("((//div[@aria-colindex='1'])//input[@name='selection'])[3]")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				Thread.sleep(500);
			} catch (Exception hi) {

			}
			driver.findElement(By.name("EmailId")).sendKeys(mail);
			Thread.sleep(500);
			driver.findElement(By.name("UserName")).sendKeys(UN);

			driver.findElement(By.name("Designation")).sendKeys(design);
			Thread.sleep(500);
			driver.findElement(By.name("MobileNo")).sendKeys(MobNo);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Add']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			Thread.sleep(700);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log(tc);
			Thread.sleep(700);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			Thread.sleep(700);
		}

		else if (tc.equals("Company field Empty")) {

			try {
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(Cname);
				Thread.sleep(700);
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])[11]")).click();
				Thread.sleep(700);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				Thread.sleep(500);

			} catch (Exception f) {

			}

			driver.findElement(By.name("UserId")).click();
			Thread.sleep(500);
			driver.findElement(By.name("UserId")).sendKeys(UserID);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])//input[@name='selection']")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				;
				Thread.sleep(500);
			} catch (Exception ex) {

			}
			//driver.findElement(By.name("RoleName")).sendKeys(role);
			;
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("((//div[@aria-colindex='1'])//input[@name='selection'])[3]")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				Thread.sleep(500);
			} catch (Exception hi) {

			}
			driver.findElement(By.name("EmailId")).sendKeys(mail);
			Thread.sleep(500);
			driver.findElement(By.name("UserName")).sendKeys(UN);

			driver.findElement(By.name("Designation")).sendKeys(design);
			Thread.sleep(500);
			driver.findElement(By.name("MobileNo")).sendKeys(MobNo);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("//button[text()='Add']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			} catch (Exception vb) {

			}
			Thread.sleep(700);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log(tc);
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		else if (tc.equals("Invalid_Mail Id")) {

			try {
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(Cname);
				Thread.sleep(700);
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])[11]")).click();
				Thread.sleep(700);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				Thread.sleep(500);

			} catch (Exception f) {

			}

			driver.findElement(By.name("UserId")).click();
			Thread.sleep(500);
			driver.findElement(By.name("UserId")).sendKeys(UserID);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])//input[@name='selection']")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				;
				Thread.sleep(500);
			} catch (Exception ex) {

			}
			//driver.findElement(By.name("RoleName")).sendKeys(role);
			;
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("((//div[@aria-colindex='1'])//input[@name='selection'])[3]")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				Thread.sleep(500);
			} catch (Exception hi) {

			}
			driver.findElement(By.name("EmailId")).sendKeys(mail);
			Thread.sleep(500);
			driver.findElement(By.name("UserName")).sendKeys(UN);

			driver.findElement(By.name("Designation")).sendKeys(design);
			Thread.sleep(500);
			driver.findElement(By.name("MobileNo")).sendKeys(MobNo);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("//button[text()='Add']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			} catch (Exception vb) {

			}
			Thread.sleep(700);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log(tc);
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			Thread.sleep(500);
		}
		else if (tc.equals("Invalid_Mob_Number")) {

			try {
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(Cname);
				Thread.sleep(700);
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])[11]")).click();
				Thread.sleep(700);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				
				Thread.sleep(500);

			} catch (Exception f) {

			}

			driver.findElement(By.name("UserId")).click();
			Thread.sleep(500);
			driver.findElement(By.name("UserId")).sendKeys(UserID);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("(//div[@aria-colindex='1'])//input[@name='selection']")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				;
				Thread.sleep(500);
			} catch (Exception ex) {

			}
			//driver.findElement(By.name("RoleName")).sendKeys(role);
			;
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("((//div[@aria-colindex='1'])//input[@name='selection'])[3]")).click();
				Thread.sleep(500);
				WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
				at.moveToElement(AddButton).click().build().perform();
				Thread.sleep(500);
			} catch (Exception hi) {

			}
			driver.findElement(By.name("EmailId")).sendKeys(mail);
			Thread.sleep(500);
			driver.findElement(By.name("UserName")).sendKeys(UN);

			driver.findElement(By.name("Designation")).sendKeys(design);
			Thread.sleep(500);
			driver.findElement(By.name("MobileNo")).sendKeys(MobNo);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("//button[text()='Add']")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
			} catch (Exception vb) {

			}
			Thread.sleep(700);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log(tc);
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			Thread.sleep(500);
		}
		
		
		
		
			else if (tc.equals("nvalid Role"))   {

				try {
					driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
					Thread.sleep(500);
					driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(Cname);
					Thread.sleep(700);
					driver.findElement(By.xpath("(//div[@aria-colindex='1'])[11]")).click();
					Thread.sleep(700);
					WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
					at.moveToElement(AddButton).click().build().perform();
					Thread.sleep(500);

				} catch (Exception f) {

				}

				driver.findElement(By.name("UserId")).click();
				Thread.sleep(500);
				driver.findElement(By.name("UserId")).sendKeys(UserID);
				Thread.sleep(500);
				try {
					driver.findElement(By.xpath("(//div[@aria-colindex='1'])//input[@name='selection']")).click();
					Thread.sleep(500);
					WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
					at.moveToElement(AddButton).click().build().perform();
					;
					Thread.sleep(500);
				} catch (Exception ex) {

				}
				driver.findElement(By.name("RoleName")).sendKeys(role);
				;
				Thread.sleep(500);
				try {
					driver.findElement(By.xpath("((//div[@aria-colindex='1'])//input[@name='selection'])[3]")).click();
					Thread.sleep(500);
					WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
					at.moveToElement(AddButton).click().build().perform();
					Thread.sleep(500);
					driver.findElement(By.name("EmailId")).sendKeys(mail);
					Thread.sleep(500);
					driver.findElement(By.name("UserName")).sendKeys(UN);

					driver.findElement(By.name("Designation")).sendKeys(design);
					Thread.sleep(500);
					driver.findElement(By.name("MobileNo")).sendKeys(MobNo);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
					Thread.sleep(500);
				} catch (Exception hi) {

				}
				
				try {
					driver.findElement(By.xpath("//button[text()='Add']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
				} catch (Exception vb) {

				}
				Thread.sleep(700);
				ts.takePageScreenshot_onPass(driver, tc);
				Reporter.log(tc);
				Thread.sleep(800);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
			}
		try {
			driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='CompanyName']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(Cname);
//			Thread.sleep(700);
//			driver.findElement(By.xpath("(//div[@aria-colindex='1'])[11]")).click();
       		Thread.sleep(700);
			WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
			at.moveToElement(AddButton).click().build().perform();
			Thread.sleep(500);

		} catch (Exception f) {

		}

		
		
		try {
		driver.findElement(By.name("UserId")).click();
		Thread.sleep(500);
		driver.findElement(By.name("UserId")).sendKeys(UserID);
		Thread.sleep(500);
		
		}catch(Exception bv)
		{
			
		}
		
		
		
		
		
		try {
			driver.findElement(By.xpath("(//div[@aria-colindex='1'])//input[@name='selection']")).click();
			Thread.sleep(500);
			WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
			at.moveToElement(AddButton).click().build().perform();
			;
			Thread.sleep(500);
		} catch (Exception ex) {

		}
		//driver.findElement(By.name("RoleName")).sendKeys(role);
		;
		Thread.sleep(500);
		try {
			driver.findElement(By.xpath("((//div[@aria-colindex='1'])//input[@name='selection'])[3]")).click();
			Thread.sleep(500);
			WebElement AddButton = driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
			at.moveToElement(AddButton).click().build().perform();
			Thread.sleep(500);
			driver.findElement(By.name("EmailId")).sendKeys(mail);
			Thread.sleep(500);
		} catch (Exception hi) {

		}
		
		
		try {
			driver.findElement(By.name("UserName")).sendKeys(UN);

			driver.findElement(By.name("Designation")).sendKeys(design);
			Thread.sleep(500);
			driver.findElement(By.name("MobileNo")).sendKeys(MobNo);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Add']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
		} catch (Exception vb) {

		}
		Thread.sleep(700);
		ts.takePageScreenshot_onPass(driver, "Invalid User Role");
		Reporter.log("Invalid User Role");
		Thread.sleep(800);
		try {
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		}catch(Exception cv)
		{
			
		}
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
	}
	
	 public static void setClipboardData(String string) throws Exception {
	        //StringSelection is a class that can be used for copy and paste operations.
		 
			Thread.sleep(1000);
	       
		 StringSelection stringSelection = new StringSelection(string);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    }


	    public  void uploadFile(String filepath) throws InterruptedException {
	        try {
	        	
	            //Setting clipboard with file location
	            setClipboardData(filepath);
	            //native key strokes for CTRL, V and ENTER keys
	            Robot robot = new Robot();

	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	    
	        } catch (Exception exp) {
	            exp.printStackTrace();
	        }
	        Thread.sleep(5000);	
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
////@AfterClass
//public void CloseBrowser() {
//	driver.close();
//}
	

	@DataProvider
	public Object[][] AddEmployee() {

		return new Object[][] {
				new Object[] { "Valid Data", "Hh", "nitin", "a", "ni@07.gmail.com", "IiT", "Non Functional testing",
						"+91 18291453", "Abcswa@12345" },
				{ "Company field Empty", "", "SSR123", "a", "sw@2023.gmail.com", "SSR", "QA Engineer", "+91 23145678",
						"Abcswa@12345" },
				{ "Invalid_Mail Id", "abc", "SSR123", "a", "wer.com", "SSR", "QA Engineer", "+91 23145678",
						"Abcswa@12345" },
				{ "Invalid_Mob_Number", "abc", "SSR123", "a", "sw@2023.gmail.com", "SSR", "QA Engineer", "3145678",
						"Abcswa@12345" },
				{ "Duplicate User", "abc", "SSR123", "a", "sw@2023.gmail.com", "SSR", "QA Engineer", "+91 23145678",
						"Abcswa@12345" },
				{"Invalid Role", "abc", "SSR123", "a", "sw@2023.gmail.com", "SSR", "123", "+91 23145678",
							"Abcswa@12345"
				}

		};
	}

	@DataProvider(name = "Login")
	public Object[][] dp1() {
		return new Object[][] {

				new Object[] { "User Login", "dsp", "Gitl@2022aa" },

		};
	}

}
