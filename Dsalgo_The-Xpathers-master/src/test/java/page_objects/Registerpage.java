package page_objects;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import constants.Constants;
import io.cucumber.datatable.DataTable;
import webdriver_manager.DriverManager;

public class Registerpage {

	private static Registerpage loginPageInstance;

	WebDriver driver = DriverManager.getDriver();

	private static final Logger LOGGER = LogManager.getLogger(Registerpage.class);

	// Dummy private constructor prevents the object creation
	public Registerpage() {

	}

	// this method prevents second object creation for the same type, Singleton
	// pattern lazy loading
	public static Registerpage getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new Registerpage();
		}
		return loginPageInstance;
	}

	@FindBy(xpath = "//form/input[@type='submit']")
	WebElement registerButton;
	@FindBy(xpath = "//*[@id='id_username']")
	WebElement user;
	@FindBy(xpath = "//*[@id='id_password1']")
	WebElement pwd;
	@FindBy(xpath = "//*[@id='id_password2']")
	WebElement confirmpwd;
	@FindBy(xpath = "//*[@class='alert alert-primary']")
	WebElement errorMsg;

	public void navigatetoRegisterPage() {
		driver.get(Constants.REG_URL);

	}

	public void clickOnRegisterButton() {
		LOGGER.info("The user clicks on Register button");
		registerButton.click();
	}

	public Boolean getEmptyRequiredUser() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (user.getText().isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", user);
		}
		return isRequired;
	}

	public Boolean getEmptyRequiredPswd() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (pwd.getText().isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", pwd);
		}
		return isRequired;
	}

	public Boolean getEmptyRequiredCofmPswd() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (confirmpwd.getText().isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", confirmpwd);
		}
		return isRequired;
	}

	public String getEmptyfieldErrormsgUser() {
		return user.getAttribute("validationMessage");
	}

	public String getEmptyfieldErrormsgPswd() {
		return pwd.getAttribute("validationMessage");
	}

	public String getEmptyfieldErrormsgCofmPswd() {
		return confirmpwd.getAttribute("validationMessage");
	}

	public void enterUsername(String username) {
		user.clear();
		user.sendKeys(username);
	}

	public void enterPassword(String password) {
		pwd.clear();
		pwd.sendKeys(password);
	}

	public String getErrormsg() {
		String msg = null;
		try {
			msg = errorMsg.getText();
		} catch (NoSuchElementException e) {
			LOGGER.info("No such element");
		}
		return msg;
	}

	public void enterCofmPassword(String cpassword) {
		confirmpwd.clear();
		confirmpwd.sendKeys(cpassword);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void entervalidUsername(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String userName = form.get("username");
			LOGGER.info("The user enter username as : " + userName);
			user.sendKeys(userName);
		}

	}

	public void entervalidPassword(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String passwd = form.get("password");
			LOGGER.info("The user enter password as : " + passwd);
			pwd.sendKeys(passwd);
		}

	}

	public void entervalidConfmPassword(DataTable dataTable) {
		List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> form : userdetail) {

			String cpasswd = form.get("password confirmation");
			LOGGER.info("The user enter confirm password as : " + cpasswd);
			confirmpwd.sendKeys(cpasswd);
		}

	}

}
