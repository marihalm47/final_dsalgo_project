package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import webdriver_manager.DriverManager;

public class GraphPage {

	private static GraphPage loginPageInstance;

	// Dummy private constructor prevents the object creation
	public GraphPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static GraphPage getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new GraphPage();
		}

		return loginPageInstance;

	}

	// user click on queue get started button in home page
	@FindBy(xpath = "//a[@href='graph']")
	WebElement graphgetstartedbutton;
	// user click on the graph link
	@FindBy(linkText = ("Graph"))
	WebElement graphpagelink;
	// click on try here link
	@FindBy(linkText = ("Try here>>>"))
	WebElement TryHereLink;
	// output
	@FindBy(id = "output")
	WebElement output;
	// Hit Run button to run code
	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;
	// editor textbox xpath
	@FindBy(xpath = "//div[@class='CodeMirror cm-s-default CodeMirror-focused']/div[1]//textarea")
	WebElement enterPythonCodetotest;
	// Graph page click on Graph representation
	@FindBy(linkText = ("Graph Representations"))
	WebElement graphrepresentationlink;
	// user click on pratice question
	@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")
	WebElement PracticeQuestionsLink;

	// user navigate to the home page
	public void navigateToHomePage() throws InterruptedException {
		DriverManager.getDriver().get(Constants.HOMEPAGEURL);
		Thread.sleep(1000);
		// Loggerload.info("user is in homepage");
	}

	// user click on get started button of graph link button
	public void graphgetstartedbutton() throws InterruptedException {
		Thread.sleep(1000);
		graphgetstartedbutton.click();
		// Loggerload.info("user clicked on graph get started button");
		Thread.sleep(1000);
	}

	// The user directed to graph Data Structure Page
	public String getGraphPageTitle() {
		String title = DriverManager.getDriver().getTitle();
		return title;
	}

	// user click on graph link
	public void Clickongraphlink() throws InterruptedException {
		Thread.sleep(1000);
		graphpagelink.click();
		// Loggerload.info("user clicked on graph link page");
		Thread.sleep(1000);
	}

	// user click on try here button
	public void Clickontryherebutton() throws InterruptedException {
		Thread.sleep(1000);
		TryHereLink.click();
		// Loggerload.info("user clicked on try here button");
		Thread.sleep(1000);
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
	public void navigateToGraphEditorUrl() {
		// DriverManager.getDriver().get(Constants.EDITORURL);
		System.out.println("EDITURL");
		DriverManager.getDriver().get(Constants.GRAPHEDITORURL);
		// Loggerload.info("User is in Graph Editor page");
	}

	// user navigate to graph data structure page
	public void navigateTographPage() throws InterruptedException {
		Thread.sleep(2000);
		DriverManager.getDriver().get(Constants.GRAPHPAGEURL);
		// Loggerload.info("User is in graph data struture page");
	}

	// User click on graph representations
	public void clickOngraphrepresentations() {
		graphrepresentationlink.click();
		// Loggerload.info("User clicked on graph representations link");
	}

	// navigate to graph representations page
	public void navigateTographPracQuesPage() {
		DriverManager.getDriver().get(Constants.GRAPHOPRATIONLINK);
	}

	// user click on Practice Questions link
	public void clickOnPracticeQuestionsLink() {
		PracticeQuestionsLink.click();
		// Loggerload.info("User clicked on Practice Questions link");
	}

}