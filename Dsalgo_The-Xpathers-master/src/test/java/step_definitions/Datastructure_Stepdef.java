package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import constants.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Datastructure;
import page_objects.HomePage;
import page_objects.SigninPage;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class Datastructure_Stepdef {

	WebDriver driver = DriverManager.getDriver();
	Datastructure DsPage = Datastructure.getInstance();
	SigninPage SignPage = SigninPage.getInstance();
	HomePage homePage = HomePage.getInstance();
	common_utils objCommounUtils = new common_utils();
	String entercode;
	private static final Logger LOGGER = LogManager.getLogger(Datastructure_Stepdef.class);

	public Datastructure_Stepdef() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

//@TestSuit_Datastructure_01
	@Given("user is in Datastructure  page after logged in")
	public void user_is_in_datastructure_page_after_logged_in() throws InterruptedException {
		driver.get(Constants.SIGNIN_URL);
		driver.manage().window().maximize();
		SignPage.Signin(Constants.USERNAME, Constants.PASSWORD);
		homePage.btn_dsintro();
//driver.get(Constants.Timecomplexitypage);
		LOGGER.info("User logged in sucessfully");

		Thread.sleep(2000);
		DsPage.Timecomplexity_link();
		LOGGER.info("User click Timecomplexity page");
	}

	@When("user clicks {string} button datastu")
	public void user_clicks_button_datastu(String string) throws InterruptedException {

		DsPage.Tryeditor_link();

	}

	@Then("user should be redirected to {string} pagedatastu")
	public void user_should_be_redirected_to_pagedatastu(String string) {
		DsPage.Tryeditor_link();

		if (driver.getCurrentUrl().contains("Timecomplexity")) {
			LOGGER.info("User in Timecomplexity ");
		}
		// assertTrue(driver.getCurrentUrl().contains("tryHereLink"));
		driver.navigate().back();
		homePage.Signout_Click();
	}

	@Then("user should be redirected to Time complexity pagedatastu")
	public void user_should_be_redirected_to_time_complexity_pagedatastu() {
		// code to - user should be redirected to Time complexity pagedatastu
		if (driver.getCurrentUrl().contains("Timecomplexity")) {
			LOGGER.info("User in Timecomplexity ");
		}
		// assertTrue(driver.getCurrentUrl().contains("tryHereLink"));
		driver.navigate().back();
		homePage.Signout_Click();
	}

//TestSuit_Datastructure_02
	@Given("user is in Time complexity page after logged in")
	public void user_is_in_time_complexity_page_after_logged_in() {
		driver.get(Constants.SIGNIN_URL);
		driver.manage().window().maximize();
		SignPage.Signin(Constants.USERNAME, Constants.PASSWORD);
		// Thread.sleep(2000);
		homePage.btn_dsintro();
		LOGGER.info("User logged in sucessfully");
		DsPage.Timecomplexity_link();
		LOGGER.info("User clicked the Time Complexity page link");

	}

	@When("user clicks {string} button in Time complexity page")
	public void user_clicks_button_in_time_complexity_page(String string) {
		DsPage.Tryeditor_link();

	}

	@Then("user displayed with a page have an tryEditor with a Run button to test and navigate to practice question page")
	public void user_displayed_with_a_page_have_an_try_editor_with_a_run_button_to_test_and_navigate_to_practice_question_page() {
		LOGGER.info("User clicked Time complexity in Dspage");
		if (driver.getCurrentUrl().contains("questions")) {
			LOGGER.info("User is in Time complexity page");
		}
		LOGGER.info("send text to editor print('dsalgo project test')");
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		DsPage.Texteditor_enterpythoncode(arrLL.get(1).get(0));
		DsPage.Runbtn_link();
		driver.navigate().back();
		driver.navigate().back();
		DsPage.Timecomplexity_link();
		DsPage.Practice_Questions_link();
		driver.navigate().back();

	}

}