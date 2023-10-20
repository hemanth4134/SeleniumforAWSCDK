package masters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.TestRunner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Calculate_ProductTotal {
	//TDDTestScreenshot bts=new TDDTestScreenshot();
	GBCSTestScreenshots bts;
	WebDriver driver;
	@BeforeTest
	public void setOutputDirectory(ITestContext context) {
		   TestRunner runner = (TestRunner) context;
		   String path=System.getProperty("user.dir");
		  // runner.setOutputDirectory(path+"/mytestreport");
		  // TestNG.getDefault().setOutputDirectory("C:\\Users\\vparab\\Documents\\project actual effort");
		 //  runner.setOutputDirectory("C:\\Users\\vparab\\Documents\\project actual effort\\Tqsreport");
		}
  @Test(priority=0)
  public void login() throws InterruptedException {
	//fail("not implemented yet");
	  //System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--start-maximized");
	  options.addArguments("--disable-web-security");
	  options.addArguments("--no-proxy-server");
      options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
      options.addArguments("--remote-allow-origins=*");
      options.setCapability("ignore-certificate-errors", true);
      WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	//driver = new RemoteWebDriver(new URL("http://172.30.62.22:4445/wd/hub/"), options);
			driver.manage().window().maximize();
			driver.get("https://www.demoblaze.com/index.html");
			Thread.sleep(5000);
			bts=new GBCSTestScreenshots();
			bts.takePageScreenshot_onPass(driver, "Demoblaze login page");
			
			//a[text()='Log in']
			driver.findElement(By.xpath("//a[text()='Log in']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("digvijayparab");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("digvijayparab");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			Thread.sleep(3000);
			bts.takePageScreenshot_onPass(driver, "Demoblaze dashboard page");
  }

  @Test(priority=1,dataProvider = "dp",enabled=true)
  public void addtocart(String product) throws Exception {
	//fail("not implemented yet");
	  try {
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[text()='Home ']")).click();
			Thread.sleep(2000);
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ARROW_DOWN);
			act.build().perform();
			act.sendKeys(Keys.ARROW_DOWN);
			act.build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Laptops']")).click();
			Thread.sleep(2000);
			act.sendKeys(Keys.ARROW_DOWN);
			act.build().perform();
			Thread.sleep(1000);
			act.sendKeys(Keys.ARROW_DOWN);
			act.build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
			Thread.sleep(1000);
			
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Cart']")).click();
			Thread.sleep(5000);
			bts.takePageScreenshot_onPass(driver, "Demoblaze"+product);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("unable to add s9");
			
			
		}
  }

  @Test(priority=2)
  public void palce_order() throws InterruptedException {
	//fail("not implemented yet");
	  String price="";
	  int accprice1=0;
	  int accprice2=0;
	  int tot=0;
	  for(int j=1;j<=3;j++)
	  {
	
	 
	 	  try {
			price= driver.findElement(By.xpath("(//td[3])["+j+"]")).getText();
			accprice1=Integer.parseInt(price);
			tot=tot+accprice1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	  }
	 	//System.out.println("total is"+tot);
	  Reporter.log("Total Bill amount is: "+tot);
				Thread.sleep(1000);
	
  }
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	 new Object[] { "Sony vaio i5" }, //
    	 new Object[] { "MacBook air" },
      
    };
  }


}
