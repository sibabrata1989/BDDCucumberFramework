package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import commonLib.BrowserHelper;
import commonLib.ExcelHelper;
import commonLib.TestConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import objectRepository.OR_App1;

public class stepDef implements OR_App1 {

	WebDriver driver = null;
	ExcelHelper objExcel = null;
	String tcName = null;
	SoftAssert softassertion;

	@Before
	public void setUp() {
		objExcel = new ExcelHelper();
		objExcel.SetListHeader(TestConfig.testDataDir + "WAMIS_TestData.xlsx", 0);
		driver = BrowserHelper.LaunchBrowser(driver);
		driver.get((TestConfig.WAMISurl));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TestConfig.SetCommonEnv();
		softassertion = new SoftAssert();
	}

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);

	}

	// Reg Exp:1.\"([^\"]*)\" 2.\"(.*)\"

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(txtUserName).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(btnLogin);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@After
	public void tearDown() {
		objExcel.ClearDataList();
		driver.close();
	}

}
