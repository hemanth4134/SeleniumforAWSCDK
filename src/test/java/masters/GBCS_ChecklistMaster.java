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
public class GBCS_ChecklistMaster {

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

		wt=new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor)driver;	
		driver.get("https://tnctrackertest.godrej.com/checklistmaster");

		driver.manage().window().maximize();
		Thread.sleep(4000);

		ts=new GBCSTestScreenshots();
		Thread.sleep(1000);
	
		LoginPage lp=new LoginPage();
		lp.valid_UserLogin(driver, "dsp", "Gitl@2022aa", "Dealer");

	}
	
		
	@Test(priority=0)
	public void NoChecklistMaintained( ) throws InterruptedException
	{
		Actions act=new Actions(driver);

		Thread.sleep(2000);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search here...']")), "00021");
		act.build().perform();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "00021");
		Thread.sleep(2000);
		//driver.navigate().refresh();
				
		act.click(driver.findElement(By.xpath("(//img[@alt='edit'])[1]")));
		act.build().perform();
		Thread.sleep(1000);

		act.click(driver.findElement(By.xpath("//span[text()='5']")));
		act.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Freeze']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "Validation massage");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		
		act.click(driver.findElement(By.xpath("//span[text()='3']")));
		act.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		
		ts.takePageScreenshot_onPass(driver, "tab3");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[15]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[16]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[17]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[18]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[19]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[20]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[21]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[text()='Add more'])[2]")).click();
		Thread.sleep(2000);
		
		act.click(driver.findElement(By.xpath("//input[@name='Parameter Category']")));
		act.build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='Parameter Category']")).sendKeys("Param1");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='Parameter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Parameter']")).sendKeys("Param1");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='Threshold Min']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Threshold Min']")).sendKeys("1");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='Threshold Max']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Threshold Max']")).sendKeys("Param1");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@col-id='UOM'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@col-id='UOM'])")).click(); 
		Thread.sleep(1000);
		
		act.sendKeys(driver.findElement(By.xpath("(//div[@col-id='UOM'])[2]")), Keys.ENTER);
		act.build().perform();
		
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys("uom");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys(Keys.TAB);
		act.build().perform();
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys("status");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys(Keys.TAB);
		act.build().perform();
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys("result");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys(Keys.TAB);
		act.build().perform();
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys("remarks");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys(Keys.TAB);
		act.build().perform();
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys("readings");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys(Keys.TAB);
		act.build().perform();
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys(Keys.TAB);
		act.build().perform();
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys(Keys.TAB);
		act.build().perform();
		driver.findElement(By.xpath("(//input[@type='text' and @ref='eInput'])")).sendKeys("attach");
		Thread.sleep(1000);
		
		ts.takePageScreenshot_onPass(driver, " Entered data in tab3");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(3000);
		
		ts.takePageScreenshot_onPass(driver, "tab4");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[text()='Add more'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='ParamCategory']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Status']")).sendKeys("status");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Remark']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Remark']")).sendKeys("remark");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(3000);
		
		ts.takePageScreenshot_onPass(driver, " Entered data in tab4");
		Thread.sleep(1000);
		
		act.click(driver.findElement(By.xpath("//span[text()='5']")));
		act.build().perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		
		ts.takePageScreenshot_onPass(driver, "Data Saved");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		
		ts.takePageScreenshot_onPass(driver, "Record Updated");
		Thread.sleep(1000);
			
	}
	
	// @AfterClass
	public void afterClass() {
		driver.close();
	}
}
