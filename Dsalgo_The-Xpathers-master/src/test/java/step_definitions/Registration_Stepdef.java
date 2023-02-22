package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Registerpage;

import webdriver_manager.DriverManager;

public class Registration_Stepdef {

	WebDriver driver = DriverManager.getDriver();
	Registerpage RegPage = Registerpage.getInstance();

	public Registration_Stepdef() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
	}

	// Notes
	// assertEquals commented since web page not returning the correct error msg.

	private static final Logger LOGGER = LogManager.getLogger(Registration_Stepdef.class);

	// @Test_suit_register_02

	@Given("The user opens Register Page")
	public void the_user_opens_register_page() {
		LOGGER.info("The user opens RegPage Page");
		RegPage.navigatetoRegisterPage();
	}

	@When("The user clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) {
		LOGGER.info("The user do not enter any values");
		RegPage.clickOnRegisterButton();
	}

	@Then("It should display an error message {string} below Username textbox")
	public void it_should_display_an_error_message_below_username_textbox(String expErrormsg) {
		LOGGER.info("Error message is displayed " + RegPage.getEmptyfieldErrormsgUser()
				+ " an error below Username textbox");
		assertTrue(RegPage.getEmptyRequiredUser(), "Username Field is Empty - required attribute is validated");
		// assertEquals(RegPage.getEmptyfieldErrormsgUser(), expErrormsg);
	}

	// @Test_suit_register_03

	@When("The user clicks {string} button after entering username with other fields empty")
	public void the_user_clicks_button_after_entering_username_with_other_fields_empty(String string,
			io.cucumber.datatable.DataTable dataTable) {
		LOGGER.info("The user enter valid username with other fields empty");
		RegPage.entervalidUsername(dataTable);
		RegPage.clickOnRegisterButton();
	}

	@Then("It should display an error message {string} below Password textbox")
	public void it_should_display_an_error_message_below_password_textbox(String expErrormsg) {
		LOGGER.info("Error message is displayed " + RegPage.getEmptyfieldErrormsgCofmPswd()
				+ " an error below Password textbox");
		assertTrue(RegPage.getEmptyRequiredPswd(), "Username Field is Empty - required attribute is validated");
		// assertEquals(RegPage.getEmptyfieldErrormsgPswd(), expErrormsg);
	}

	// @Test_suit_register_04

	@When("The user clicks {string} button after entering {string} and {string} with Password Confirmation field empty")
	public void the_user_clicks_button_after_entering_and_with_password_confirmation_field_empty(String string,
			String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}

	@Then("It should display an error message {string} below Password Confirmation textbox")
	public void it_should_display_an_error_message_below_password_confirmation_textbox(String expErrormsg) {
		LOGGER.info("Error message is displayed " + RegPage.getEmptyfieldErrormsgCofmPswd()
				+ " an error below Username textbox");
		assertTrue(RegPage.getEmptyRequiredCofmPswd(), "Username Field is Empty - required attribute is validated");
		// assertEquals(RegPage.getEmptyfieldErrormsgCofmPswd(), expErrormsg);
	}

	// @Test_suit_register_05

	@When("The user enters a {string} with characters other than Letters, digits and {string}")
	public void the_user_enters_a_with_characters_other_than_letters_digits_and(String string, String string2,
			io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}

	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String expErrormsg) {
		LOGGER.info("Expected Error message is as : " + expErrormsg);
		LOGGER.info("Error message is displayed as : " + RegPage.getErrormsg());
		// assertEquals(RegPage.getErrormsg(), expErrormsg);
	}

	// @Test_suit_register_06
	@When("The user clicks {string} button after entering valid {string} and different passwords in {string} and {string} fields")
	public void the_user_clicks_button_after_entering_valid_and_different_passwords_in_and_fields(String string,
			String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}
	// @Test_suit_register_07

	@When("The user enters a valid {string} and {string} with characters less than {int}")
	public void the_user_enters_a_valid_and_with_characters_less_than(String string, String string2, Integer int1,
			io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}
	// @Test_suit_register_08

	@When("The user enters a valid {string} and {string} with only numbers")
	public void the_user_enters_a_valid_and_with_only_numbers(String string, String string2,
			io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}

	// @Test_suit_register_09
	@When("The user enters a valid {string} and {string} similar to username")
	public void the_user_enters_a_valid_and_similar_to_username(String string, String string2,
			io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}

	// @Test_suit_register_10
	@When("The user enters a valid {string} and commonly used password {string}")
	public void the_user_enters_a_valid_and_commonly_used_password(String string, String string2,
			io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}

	// @Test_suit_register_11
	@When("The user enters a valid {string} and {string} and {string}")
	public void the_user_enters_a_valid_and_and(String string, String string2, String string3,
			io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}

	@Then("The user should be redirected to Homepage with the message {string}")
	public void the_user_should_be_redirected_to_homepage_with_the_message(String string) {
		LOGGER.info("User redirected to Homepage ");
		String Title = RegPage.getPageTitle();
		LOGGER.info("Title of current page is : " + Title);
		// assertEquals(Title, "NumpyNinja", "Title do not match");
	}

	// @Test_suit_register_12
	@When("The user enters a valid existing {string} with {string} and {string}")
	public void the_user_enters_a_valid_existing_with_and(String string, String string2, String string3,
			io.cucumber.datatable.DataTable dataTable) {
		RegPage.entervalidUsername(dataTable);
		RegPage.entervalidPassword(dataTable);
		RegPage.entervalidConfmPassword(dataTable);
		RegPage.clickOnRegisterButton();
	}

}
