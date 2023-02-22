package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import webdriver_manager.DriverManager;

public class QueuePage {

	private static QueuePage loginPageInstance;

	// Dummy private constructor prevents the object creation
	public QueuePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static QueuePage getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new QueuePage();
		}

		return loginPageInstance;

	}

	// user click on queue getstarted button in home page
	@FindBy(xpath = "//a[@href='queue']")
	WebElement queuegetstartedbutton;

	// Queue page click on Implementation of Queue in Python
	@FindBy(xpath = "//a[normalize-space()='Implementation of Queue in Python']")
	WebElement ImplementationQueuePythonLink;

	// click on try here link
	@FindBy(linkText = ("Try here>>>"))
	WebElement TryHereLink;

	// editor textbox xpath
	@FindBy(xpath = "//div[@class='CodeMirror cm-s-default CodeMirror-focused']/div[1]//textarea")
	WebElement enterPythonCodetotest;

	// output
	@FindBy(id = "output")
	WebElement output;

	// Hit Run button to run code
	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;

	// Queue page click on Implementation using collections deque link
	@FindBy(linkText = ("Implementation using collections.deque"))
	WebElement ImpCollectionsDequeLink;

	// Queue page click on Implementation using Array link
	@FindBy(linkText = ("Implementation using array"))
	WebElement ImpUsingArrayLink;

	// Queue page click on Queue Operations page
	@FindBy(linkText = ("Queue Operations"))
	WebElement QueueOperationsLink;

	// Queue page click on Practice question link
	// @FindBy(linkText=("Practice Questions"))WebElement PracticeQuestionsLink;

	@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")
	WebElement PracticeQuestionsLink;

	public void navigateToHomePage() throws InterruptedException {
		// DriverManager.getDriver().get(Constants.HOMEPAGEURL);
		Thread.sleep(1000);
		// Loggerload.info("user is in homepage");
	}

	public void queuegetstartedbutton() throws InterruptedException {
		Thread.sleep(1000);
		queuegetstartedbutton.click();
		// Loggerload.info("user clicked on Queue button");
		Thread.sleep(1000);
	}

	// The user directed to Queue Data Structure Page
	public String getQueuePageTitle() {
		String title = DriverManager.getDriver().getTitle();
		return title;
	}

	// user click on the Implementation of Queue Python Link
	public void clickOnImplementationQueuePythonLink() throws InterruptedException {

		// Loggerload.info("click " + ImplementationQueuePythonLink.getText() + " in
		// Queue page");
		Thread.sleep(1000);
		ImplementationQueuePythonLink.click();
		// Loggerload.info("User clicked on Implementation of Queue Python Link ");
	}

	// click on try here link
	public void clickOnTryHereLink() throws InterruptedException {
		TryHereLink.click();
		Thread.sleep(1000);
		// Loggerload.info("User clicked on Try here link");

	}

	// enter valid python code in editor
	public void EnterPhytonCode(String validPhytonCode) {

		enterPythonCodetotest.sendKeys(validPhytonCode);

	}

	// Enter run button
	public void clickOnRunButton() {
		runButton.click();
		// Loggerload.info("User clicked on Run Button");
	}

	// to get actual valid result
	public String getActualResult() {

		return output.getText();
	}

	// enter invalid python code in editor
	public void InvalidPhytonCode(String enterinvalidCode) throws InterruptedException {
		Thread.sleep(2000);
		enterPythonCodetotest.sendKeys(enterinvalidCode);

	}

	// alert pop up ok for invalid python code
	public String getErrorText() throws InterruptedException {
		Thread.sleep(2000);
		String errorMsg = DriverManager.getDriver().switchTo().alert().getText();
		DriverManager.getDriver().switchTo().alert().accept();
		return errorMsg;
	}

	// User will be in editor page
	public void navigateToEditorUrl() {
		// DriverManager.getDriver().get(Constants.EDITORURL);
		System.out.println("EDITURL");
		DriverManager.getDriver().get(Constants.EDITORURL);
		// Loggerload.info("User is in editor page");
	}

	// user navigate to queue data structure page
	public void navigateToQueuePage() throws InterruptedException {
		Thread.sleep(2000);
		DriverManager.getDriver().get(Constants.QUEUEPAGEURL);
		// Loggerload.info("User is in queue page");
	}

	// User clicked on Implementation using collections deque link
	public void clickOnImpUsingCollLink() {
		// Loggerload.info("click " + ImpCollectionsDequeLink.getText() + "On Queue
		// page");
		ImpCollectionsDequeLink.click();
		// Loggerload.info("User clicked on Implementation using collections deque
		// link");
	}

	// User click on Imp using array
	public void clickOnImpUsingArray() {
		ImpUsingArrayLink.click();
		// Loggerload.info("User clicked on Implementation using array link");
	}

	// User click on Queue Operations link
	public void clickOnQueueOperlink() {
		QueueOperationsLink.click();
		// Loggerload.info("User clicked on Queue Operations page");
	}

	// navigate to queue operation page
	public void navigateToQPracQuesPage() {
		DriverManager.getDriver().get(Constants.QUEUEOPRATIONLINK);
	}

	// user click on Practice Questions link
	public void clickOnPracticeQuestionsLink() {
		PracticeQuestionsLink.click();
		// Loggerload.info("User clicked on Practice Questions link");
	}
}