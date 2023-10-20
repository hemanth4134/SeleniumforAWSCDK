package masters;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DesignReviewTracker {

	WebDriver driver;
	GBCSTestScreenshots ts = new GBCSTestScreenshots();
	User_Master us = new User_Master();
	Actions s;

	@BeforeTest
	public void BrowserOpen()

	{
		// Browser launching.
		//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
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
			Thread.sleep(1000);
			driver.findElement(By.name("userName")).sendKeys(mail);
			Thread.sleep(1000);
			driver.findElement(By.name("password")).sendKeys(pwd);

			Thread.sleep(1000);
			WebElement LoginButton = driver.findElement(By.xpath("//button[text()='Login']"));

			Actions act = new Actions(driver);
			act.moveToElement(LoginButton).click().build().perform();

			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='sidebar-head']")).click();
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h2 LogIn </h2>");
			Thread.sleep(1000);
			WebElement Transactions = driver.findElement(By.xpath("//span[text()='Transaction ']"));
			act.moveToElement(Transactions).click().build().perform();
			Thread.sleep(500);
			WebElement DRT = driver.findElement(By.xpath("//a[text()='Design Review Tracker']"));
			act.moveToElement(DRT).click().build().perform();

			Thread.sleep(2000);

			WebElement SVG = driver.findElement(By.cssSelector(
					"#root > div > div > div.app-container > div.main-container.container-fluid > div.action-comp-container.container-fluid > div > div.action-project.col-lg-3.col-md-3.col-12 > div > svg"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(SVG).click().build().perform();
			Thread.sleep(1000);

			driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[12]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("tesproj");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@ref='applyFilterButton']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@id='selection0'])[1]")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[text()='Add']")).click();

		}

	}

 @Test(priority = 2, dataProvider = "Add")
	public void AddNewReviewTracker(String tc, String DocRefer, String RevNumber, String Service, String SectionNum)
			throws Exception {
		Actions act = new Actions(driver);

		// Add record button

		driver.findElement(By.xpath("//span[text()='Add New']")).click();

		/*
		 * Thread.sleep(4000);
		 * driver.findElement(By.xpath("//input[@name='IssueDate']")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//input[@name='IssueDate']")).clear();
		 * Thread.sleep(1000); driver.findE
		 * lement(By.xpath("//input[@name='IssueDate']")).sendKeys(IssueDate);
		 */

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#DocumentRefrence")).sendKeys(DocRefer);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#DocumentRefrence")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='RevisionNo']")).sendKeys(RevNumber);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='RevisionNo']")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		WebElement Pages = driver.findElement(By.xpath("//input[@name='PageNo']"));
		act.moveToElement(Pages).click().build().perform();
		Thread.sleep(1000);

		if (tc.equals("Invalid page Number")) {
			act.sendKeys(Keys.DOWN).build().perform();
		} else {
			act.sendKeys(Keys.UP).build().perform();
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h2 LogIn </h2>");

		}
		Thread.sleep(2000);
		WebElement ServiceName = driver.findElement(
				By.cssSelector("#designreviewtracker > div:nth-child(2) > div:nth-child(3) > div > div > svg"));
		act.moveToElement(ServiceName).click().build().perform();
		Thread.sleep(500);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"body > div:nth-child(6) > div > div > div.modal-body > div > div.row > div.global-search-container > div > div > div > input"))
				.sendKeys(Service);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='selection'])[1]")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,300)");

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Add'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='SectionNo']")).sendKeys(SectionNum);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='SectionNo']")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='GodrejComment']")).sendKeys("abc");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='ConsultantResponse']")).sendKeys("def");
		Thread.sleep(3000);
		WebElement File = driver.findElement(By.xpath("(//div[@class='col-lg-12 col-md-12 col-12'])[4]"));

		// .sendKeys("C:\\Users\\rswapnil\\Documents\\dump\\dump\\Report1.JPG").build().perform();
		Robot r = new Robot();
		StringSelection s = new StringSelection("C:\\Users\\vparab\\Documents\\dump\\dump\\Report1.JPG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		act.moveToElement(File).click().build().perform();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		r.setAutoDelay(1000);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		WebElement StatusDrt = driver.findElement(By.name("DRTStatus"));

		act.moveToElement(StatusDrt).click().build().perform();

		for (int i = 0; i <= 3; i++) {
			act.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//textarea[@name='ClosingRemark']")).sendKeys("Null");
		Thread.sleep(1000);
		try {

			driver.findElement(By.xpath("//button[text()='Add']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(3000);

		try {
			driver.findElement(By.xpath("//button[text()='Yes']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(2000);

		try {
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h2 Design Tracker added </h2>");
			driver.findElement(By.xpath("//button[text()='OK']")).click();

		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(1000);

		if (tc.equals("Invalid page Number")) {
			try {
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

//		driver.findElement(By.xpath("(//div[@class='col-lg-12 col-md-12 col-12'])[4]")).sendKeys("//C:/Users/rswapnil/Documents/dump/dump/Passed_TCs.pdf");

	}

	 @Test(dataProvider = "RefrenceDocs", priority = 3 )
	public void RefrenceDocumentsValidation(String tc) throws Exception {

		Thread.sleep(1000);
		Actions ac = new Actions(driver);

		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Add New']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='PageNo']")).sendKeys("2");
		driver.findElement(By.cssSelector("#DocumentRefrence")).sendKeys("TRTIOP");

		Thread.sleep(1000);

		WebElement File = driver.findElement(By.xpath("(//div[@class='col-lg-12 col-md-12 col-12'])[4]"));
		ac.moveToElement(File).click().build().perform();

		if (tc.equals("Upload_Excel")) {
			String filepath1 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Autmation ROI calculation.xlsx";
			us.uploadFile(filepath1);
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h2 Excel File Uploaded Successfully </h2>");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();

		}

		else if (tc.equals("Upload_Docs"))

		{

			String filepath1 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Automation_Testing_QG_V1.docx";
			// "C:\Users\rswapnil\Documents\dump\dump\Automation_Testing_QG_V1c"
			us.uploadFile(filepath1);
			Thread.sleep(1000);
			ts.printAlertmsg(driver);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h2 Docs File Uploaded Successfully </h2>");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();

		}

		else if (tc.equals("Upload_pdf")) {
			String filepath1 = "C:\\Users\\vparab\\Documents\\Passed_TCs.pdf";
			us.uploadFile(filepath1);
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h2 Pdf File Uploaded Successfully </h2>");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();

		}

		else if (tc.equals("InvalidFileName")) {
			String filepath1 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Test-Automation-Frameworks-7.jpg";
			us.uploadFile(filepath1);
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log(tc);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();

		}

		else if (tc.equals("Upload_jpg")) {
			String filepath1 = "C:\\Users\\vparab\\Documents\\dump\\dump\\Report1.JPG";
			us.uploadFile(filepath1);
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h2 Jpg File Uploaded Successfully </h2>");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();

		}

		// "C:\Users\rswapnil\Documents\TC_20 1.png"

		else if (tc.equals("Upload_png")) {
			String filepath1 = "C:\\Users\\vparab\\Documents\\dump\\dump\\TestAutomationStrategy7681043.png";
			us.uploadFile(filepath1);
			Thread.sleep(2000);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log("<h1 png File Uploaded Successfully </h1>");
			Thread.sleep(200);

			driver.findElement(By.xpath("//button[@class='btn-close']")).click();

		}

		else if (tc.equals("Max Size file upload validation")) {

			String filepath1 = "C:\\Users\\vparab\\Documents\\dump\\dump\\FSD AEM.docx";

			us.uploadFile(filepath1);
			Thread.sleep(1000);
			ts.takePageScreenshot_onPass(driver, tc);
			Reporter.log(tc);
			Thread.sleep(1000);

			try {
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='btn-close']")).click();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Test(priority = 5)
	public void GlobalSearchAndDownload() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='downloadimg']")).click();
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "ExcelDownloadForAllRecords");
		Reporter.log("ExcelDownloadForAllRecords");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("Gid");
		Thread.sleep(1000);
		ts.takePageScreenshot_onPass(driver, "GlobalSearch");
		Reporter.log("GlobalSearch");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@placeholder='Search here...']")).sendKeys("Gide3244");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='downloadimg']")).click();
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "ExcelDownload for single record");
		Reporter.log("ExcelDownload for single record");
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//input[@placeholder='Search here...']")).clear();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	//@Test(priority = 4)
	public void ColumnSearch() throws Exception {
		Thread.sleep(1000);
		s = new Actions(driver);

				//SearchBySr.No
				
				WebElement tri=driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[1]"));
				s.moveToElement(tri).click().build().perform();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("3");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@type='submit'])")).click();
				Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, "Search By Sr.No");
				Reporter.log("Search By Sr.No");
				Thread.sleep(1000);
				try {
					driver.findElement(By.xpath("//button[text()='Clear All']")).click();
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
//				//SearchByStatus
				
				WebElement Status=driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[2]"));
				s.moveToElement(Status).click().build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("Hold");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@type='submit'])")).click();
				Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, "Search By Status");
				Reporter.log("Search By Status");
				Thread.sleep(1000);
				try {
					driver.findElement(By.xpath("//button[text()='Clear All']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
                //SearchByIssueDate
				
				WebElement IssueDate=driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[3]"));
				s.moveToElement(IssueDate).click().build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("28-06-2023");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@type='submit'])")).click();
				Thread.sleep(1000);
				ts.takePageScreenshot_onPass(driver, "Search By IssueDate");
				Reporter.log("Search By IssueDate");
				Thread.sleep(1000);
				try {
					driver.findElement(By.xpath("//button[text()='Clear All']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
                //SearchByDocumentRefrence
				
				WebElement DocumentRefrence=driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[4]"));
				s.moveToElement(DocumentRefrence).click().build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("DIDE3244");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@type='submit'])")).click();
				Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, "SearchByDocumentRefrence");
				Reporter.log("SearchByDocumentRefrence");
				Thread.sleep(1000);
				try {
					driver.findElement(By.xpath("//button[text()='Clear All']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
                //SearchByRevisionNo
				WebElement RevisionNo=driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[5]"));
				s.moveToElement(RevisionNo).click().build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("190");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@type='submit'])")).click();
				Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, "SearchByRevisionNo");
				Reporter.log("SearchByRevisionNo");
				Thread.sleep(1000);
				try {
					driver.findElement(By.xpath("//button[text()='Clear All']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				//SearchByPageNo.
				WebElement PageNo=driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[6]"));
				s.moveToElement(PageNo).click().build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("1");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@type='submit'])")).click();
				Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, "SearchByPageNo.");
				Reporter.log("SearchByPageNo.");
				Thread.sleep(1000);
				try {
					driver.findElement(By.xpath("//button[text()='Clear All']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				//SearchByServiceName
				WebElement ServiceName=driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[7]"));
				s.moveToElement(ServiceName).click().build().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("HVAC");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@type='submit'])")).click();
				Thread.sleep(500);
				ts.takePageScreenshot_onPass(driver, "SearchByServiceName");
				Reporter.log("SearchByServiceName");
				Thread.sleep(1000);
				try {
					driver.findElement(By.xpath("//button[text()='Clear All']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}

		// SearchBySectionNo
		WebElement SectionNo = driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[8]"));
		s.moveToElement(SectionNo).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("121");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "SearchBySectionNo");
		Reporter.log("SearchBySectionNo");
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(3000);
		WebElement Scrollbar = (new WebDriverWait(driver, Duration.ofSeconds(10)))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
						"#root > div > div > div.app-container > div.main-container.container-fluid > div.grid-comp-container.container-fluid > div.ag-theme-alpine.agGridContainer.d-none.d-md-block.d-lg-block > div > div > div.ag-root-wrapper-body.ag-focus-managed.ag-layout-normal > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-body-horizontal-scroll > div.ag-body-horizontal-scroll-viewport")));
		Scrollbar.click();
		s.moveToElement(Scrollbar).clickAndHold();
		s.moveByOffset(500, 0);
		s.release();
		s.perform();

		Thread.sleep(3000);

		// SearchByGodrejComment
		WebElement GodrejComment = driver.findElement(By.cssSelector(
				"#root > div > div > div.app-container > div.main-container.container-fluid > div.grid-comp-container.container-fluid > div.ag-theme-alpine.agGridContainer.d-none.d-md-block.d-lg-block > div > div > div.ag-root-wrapper-body.ag-focus-managed.ag-layout-normal > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-header.ag-pivot-off > div.ag-header-viewport > div > div > div:nth-child(7) > div.ag-header-cell-comp-wrapper > div > span > span"));
		s.moveToElement(GodrejComment).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("abc");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "SearchByGodrejComment");
		Reporter.log("SearchByGodrejComment");
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// SearchByConsultantResponce
		WebElement ConsultantResponce = driver.findElement(By.cssSelector(
				"#root > div > div > div.app-container > div.main-container.container-fluid > div.grid-comp-container.container-fluid > div.ag-theme-alpine.agGridContainer.d-none.d-md-block.d-lg-block > div > div > div.ag-root-wrapper-body.ag-focus-managed.ag-layout-normal > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-header.ag-pivot-off > div.ag-header-viewport > div > div > div:nth-child(8) > div.ag-header-cell-comp-wrapper > div > span > span"));
		s.moveToElement(ConsultantResponce).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("def");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "SearchByConsultantResponce");
		Reporter.log("SearchByConsultantResponce");
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// SearchByLastUpdate/ClosureDate
		WebElement ClosureDate = driver.findElement(By.xpath("(//span[@ref='eMenu'])[9]"));
		s.moveToElement(ClosureDate).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("30-06-2023");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
		Thread.sleep(1000);
		
		ts.takePageScreenshot_onPass(driver, "SearchByClosureDate");
		Reporter.log("SearchByClosureDate");
		
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// SearchByClosingRemark
		WebElement ClosingRemark = driver.findElement(By.cssSelector(
				"#root > div > div > div.app-container > div.main-container.container-fluid > div.grid-comp-container.container-fluid > div.ag-theme-alpine.agGridContainer.d-none.d-md-block.d-lg-block > div > div > div.ag-root-wrapper-body.ag-focus-managed.ag-layout-normal > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-header.ag-pivot-off > div.ag-header-viewport > div > div > div:nth-child(10) > div.ag-header-cell-comp-wrapper > div > span > span"));
		s.moveToElement(ClosingRemark).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@ref='eInput'])[12]")).sendKeys("Null");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
		Thread.sleep(500);
		ts.takePageScreenshot_onPass(driver, "SearchByClosingRemark");
		Reporter.log("SearchByClosingRemark");
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//button[text()='Clear All']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	 @DataProvider(name = "RefrenceDocs")
	public Object[][] dp3() {
		return new Object[][] {

				new Object[] { "Upload_Excel" }, 
			//	new Object[] { "Upload_Docs" }, 
				new Object[] { "Upload_pdf" },
				new Object[] { "InvalidFileName" }, 
				new Object[] { "Upload_jpg" }, new Object[] { "Upload_png" },

				new Object[] { "Max Size file upload validation" },

		};
	}

	 @DataProvider(name = "Add")
	public Object[][] dp2() {
		return new Object[][] {

				new Object[] { "valid Review", "JKTL12", "190", "HVAC", "111" },
				new Object[] { "Invalid page Number", "Doc98", "12", "HVAC", "121" }

		};
	}

	@DataProvider(name = "Login")
	public Object[][] dp1() {
		return new Object[][] {

				new Object[] { "User Login", "dsp", "Gitl@2022aa" },

		};

	}

}
