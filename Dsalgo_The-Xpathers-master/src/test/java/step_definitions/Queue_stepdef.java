package step_definitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.GraphPage;
import page_objects.HomePage;
import page_objects.QueuePage;
import page_objects.SigninPage;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class Queue_stepdef {

	WebDriver driver = DriverManager.getDriver();
	QueuePage ObjQueuePage = QueuePage.getInstance();
	SigninPage SignPage = SigninPage.getInstance();
	HomePage homePage = HomePage.getInstance();
	GraphPage objgraphpg = GraphPage.getInstance();
	common_utils objCommounUtils = new common_utils();
	String enterCode;

	private static final Logger LOGGER = LogManager.getLogger(Queue_stepdef.class);

	public Queue_stepdef() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

//@TestDemo_Queue_01
	@Given("user is logged into the home page")
	public void user_is_logged_into_the_home_page() {
		// ObjQueuePage.navigateToHomePage();
		driver.get(Constants.SIGNIN_URL);
		driver.manage().window().maximize();
		SignPage.Signin(Constants.USERNAME, Constants.PASSWORD);
		System.out.println("User is in Queue Home Page");
		// DriverManager.getDriver().get(Constants.HOMEPAGEURL);
	}

	@When("user clicks on get started button or dropdown for queue")
	public void user_clicks_on_get_started_button_or_dropdown_for_queue() throws InterruptedException {
		ObjQueuePage.queuegetstartedbutton();
		System.out.println("User Clicks on Get Started button Queue Page");

	}

	@Then("user directed to the queue page")
	public void user_directed_to_the_queue_page() {

		System.out.println("User Clicks on queue page");
	}

//@TestSuite_queue_02	
	@Given("The user in queue page")
	public void the_user_in_queue_page() {
		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is : " + Title);
		assertEquals(Title, "Queue", "Title not matched");

	}

	@When("user clicks on Implementation of Queue in Python link page")
	public void user_clicks_on_implementation_of_queue_in_python_link_page() throws InterruptedException {

		ObjQueuePage.clickOnImplementationQueuePythonLink();
	}

	@Then("user should be directed to Implementation of Queue in Python link page")
	public void user_should_be_directed_to_implementation_of_queue_in_python_link_page() {

		System.out.println("user should be directed to Implementation of Queue in Python link page");
	}

//@TestSuite_queue_03	
	@Given("The user is in Implementation of queue in python link page")
	public void the_user_is_in_implementation_of_queue_in_python_link_page() {
		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Implementation of Queue in Python", "Title not matched");

	}

	@When("The user clicks on Tryhere link for Implementation of queue in python")
	public void the_user_clicks_on_tryhere_link_for_implementation_of_queue_in_python() throws InterruptedException {
		ObjQueuePage.clickOnTryHereLink();

	}

	@Then("The user navigates to Editor page to enter valid python code for Implementation of queue in python")
	public void the_user_navigates_to_editor_page_to_enter_valid_python_code_for_implementation_of_queue_in_python() {

		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");

		// ObjQueuePage.EnterPhytonCode("print(\"Implementation in Queue\")");

		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjQueuePage.EnterPhytonCode(arrLL.get(1).get(0));
	}

	@Then("user clicks on the run button for Implementation of queue in python")
	public void user_clicks_on_the_run_button_for_implementation_of_queue_in_python() {

		ObjQueuePage.clickOnRunButton();

	}

	@Then("The user is presented with the result after run button is clicked for Implementation of queue in python")
	public void the_user_is_presented_with_the_result_after_run_button_is_clicked_for_implementation_of_queue_in_python() {
		// LOGGER.info("Expected result - : " + expectedMsg);
		String actualMsg = ObjQueuePage.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, "hello", "Result Matched");
		// assertEquals(actualMsg, "Implementation in Queue");
		// System.out.println("Result_after_run_button_is_clicked");
	}

//@TestSuite_queue_04  	
	@Given("The user is in a page having an Editor with a Run button to test for Implementation of queue in python")
	public void the_user_is_in_a_page_having_an_editor_with_a_run_button_to_test_for_implementation_of_queue_in_python() {
		System.out.println(
				"The user is in a page having an Editor with a Run button to test for Implementation of queue in python");
		ObjQueuePage.navigateToEditorUrl();
	}

	@When("The user enters invalid python code for Implementation of queue in python")
	public void the_user_enters_invalid_python_code_for_implementation_of_queue_in_python()
			throws InterruptedException {
		// ObjQueuePage.navigateToEditorUrl();
		// ObjQueuePage.InvalidPhytonCode("print\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLLin = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count invalid :" + String.valueOf(arrLLin.size()));
		ObjQueuePage.EnterPhytonCode(arrLLin.get(1).get(1));
	}

	@When("clicks run button for Implementation of queue")
	public void clicks_run_button_for_implementation_of_queue() {
		ObjQueuePage.clickOnRunButton();

	}

	@Then("The user gets an error message for Implementation of queue")
	public void the_user_gets_an_error_message_for_implementation_of_queue() throws InterruptedException {

		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = ObjQueuePage.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		// assertEquals(actualMsg,"SyntaxError: bad input on line 1", "Result do not
		// match");
		assertEquals(actualMsg, "NameError: name 'hello' is not defined on line 1", "Result do not match");
	}

	// @TestSuite_queue_05
	@Given("User in editor page and navigates to the queue page for Implementation using collections deque link")
	public void user_in_editor_page_and_navigates_to_the_queue_page_for_implementation_using_collections_deque_link()
			throws InterruptedException {

		ObjQueuePage.navigateToQueuePage();

	}

	@When("User clicks on Implementation using collections deque link")
	public void user_clicks_on_implementation_using_collections_deque_link() {

		ObjQueuePage.clickOnImpUsingCollLink();
	}

	@Then("User should be redirected to Implementation using collections deque page")
	public void user_should_be_redirected_to_implementation_using_collections_deque_page() {

		System.out.println("The user should be redirected to Implementation using collections deque page");

	}

//@TestSuite_queue_06	
	@Given("User in implementation using collections page")
	public void user_in_implementation_using_collections_page() {

		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is " + Title);
		assertEquals(Title, "Implementation using collections.deque", "Title not matched");
	}

	@When("User clicks on Tryhere link for collections page")
	public void user_clicks_on_tryhere_link_for_collections_page() throws InterruptedException {

		ObjQueuePage.clickOnTryHereLink();

	}

	@Then("User navigates to Editor page to enter valid python code for collections page")
	public void user_navigates_to_editor_page_to_enter_valid_python_code_for_collections_page() {
		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");

		// ObjQueuePage.EnterPhytonCode("print(\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjQueuePage.EnterPhytonCode(arrLL.get(1).get(0));

	}

	@Then("User clicks on the run button for collections page")
	public void user_clicks_on_the_run_button_for_collections_page() {

		ObjQueuePage.clickOnRunButton();

	}

	@Then("The user is presented with the result after run button is clicked for collections page")
	public void the_user_is_presented_with_the_result_after_run_button_is_clicked_for_collections_page() {

		String actualMsg = ObjQueuePage.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, "hello", "Result Matched");

	}

//TestSuite_queue_07	
	@Given("User is in a page having an Editor with a Run button to test for collection page")
	public void user_is_in_a_page_having_an_editor_with_a_run_button_to_test_for_collection_page() {
		ObjQueuePage.navigateToEditorUrl();
		System.out.println("user is in a page having an Editor with a Run button to test for collection page");

	}

	@When("User enters invalid python code in Editor for collections page")
	public void user_enters_invalid_python_code_in_editor_for_collections_page() throws InterruptedException {

		// ObjQueuePage.InvalidPhytonCode("print\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLLin = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count invalid :" + String.valueOf(arrLLin.size()));
		ObjQueuePage.EnterPhytonCode(arrLLin.get(1).get(1));
	}

	@When("clicks run button for collection page link")
	public void clicks_run_button_for_collection_page_link() {

		ObjQueuePage.clickOnRunButton();
	}

	@Then("The user gets an error message for collection page")
	public void the_user_gets_an_error_message_for_collection_page() throws InterruptedException {

		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = ObjQueuePage.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		// assertEquals(actualMsg,"SyntaxError: bad input on line 1", "Result do not
		// match");
		assertEquals(actualMsg, "NameError: name 'hello' is not defined on line 1", "Result do not match");
	}

//TestSuite_queue_08
	@Given("User in editor page and navigates to the queue page for Implementation using array link")
	public void user_in_editor_page_and_navigates_to_the_queue_page_for_implementation_using_array_link()
			throws InterruptedException {

		ObjQueuePage.navigateToQueuePage();
	}

	@When("The user clicks on Implementation using array link")
	public void the_user_clicks_on_implementation_using_array_link() {

		ObjQueuePage.clickOnImpUsingArray();
	}

	@Then("The user should be redirected to Implementation using array page")
	public void the_user_should_be_redirected_to_implementation_using_array_page() {

		System.out.println("User should be redirected to Implementation using array page");

	}

//TestSuite_queue_09
	@Given("User in Implementation using array link")
	public void user_in_implementation_using_array_link() {

		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is " + Title);
		assertEquals(Title, "Implementation using array", "Title not matched");
	}

	@When("User clicks on Tryhere link from Implementation using array link")
	public void user_clicks_on_tryhere_link_from_implementation_using_array_link() throws InterruptedException {

		ObjQueuePage.clickOnTryHereLink();

	}

	@Then("User navigates to Editor page to enter valid python code for array link")
	public void user_navigates_to_editor_page_to_enter_valid_python_code_for_array_link() {

		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");

		// ObjQueuePage.EnterPhytonCode("print(\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjQueuePage.EnterPhytonCode(arrLL.get(1).get(0));

	}

	@Then("User clicks on the run button for array link")
	public void user_clicks_on_the_run_button_for_array_link() {

		ObjQueuePage.clickOnRunButton();
	}

	@Then("User is presented with the result after run button is clicked for array link")
	public void user_is_presented_with_the_result_after_run_button_is_clicked_for_array_link() {

		String actualMsg = ObjQueuePage.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
		// assertEquals(actualMsg, "Implementation in Queue");
		assertEquals(actualMsg, "hello", "Result Matched");
	}

//TestSuite_queue_10

	@Given("User is in a page having an Editor with a Run button to test for array page")
	public void user_is_in_a_page_having_an_editor_with_a_run_button_to_test_for_array_page() {
		ObjQueuePage.navigateToEditorUrl();
		System.out.println("user is in a page having an Editor with a Run button to test Array Page");

	}

	@When("User enters invalid python code in Editor for array page.")
	public void user_enters_invalid_python_code_in_editor_for_array_page() throws InterruptedException {

		// ObjQueuePage.InvalidPhytonCode("print\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLLin = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count invalid :" + String.valueOf(arrLLin.size()));
		ObjQueuePage.EnterPhytonCode(arrLLin.get(1).get(1));
	}

	@When("clicks run button for array page")
	public void clicks_run_button_for_array_page() {

		ObjQueuePage.clickOnRunButton();
	}

	@Then("The user gets an error message for array page")
	public void the_user_gets_an_error_message_for_array_page() throws InterruptedException {

		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = ObjQueuePage.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		// assertEquals(actualMsg,"SyntaxError: bad input on line 1", "Result do not
		// match");
		assertEquals(actualMsg, "NameError: name 'hello' is not defined on line 1", "Result do not match");
	}

//@TestSuite_queue_11
	@Given("User in editor page and navigates to the queue page for Queue Operations link")
	public void user_in_editor_page_and_navigates_to_the_queue_page_for_queue_operations_link()
			throws InterruptedException {

		ObjQueuePage.navigateToQueuePage();

	}

	@When("The user clicks on Queue Operations link")
	public void the_user_clicks_on_queue_operations_link() {

		ObjQueuePage.clickOnQueueOperlink();
	}

	@Then("The user should be redirected to Queue Operations page")
	public void the_user_should_be_redirected_to_queue_operations_page() {

		System.out.println("User should be redirected to Implementation using array page");
	}

//@TestSuite_queue_12
	@Given("User in Queue Operations link")
	public void user_in_queue_operations_link() {

		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is " + Title);
		assertEquals(Title, "Queue Operations", "Title not matched");
	}

	@When("User clicks on Tryhere link from Queue Operations link")
	public void user_clicks_on_tryhere_link_from_queue_operations_link() throws InterruptedException {

		ObjQueuePage.clickOnTryHereLink();
	}

	@Then("User navigates to Editor page to enter valid python code for Queue Operations link")
	public void user_navigates_to_editor_page_to_enter_valid_python_code_for_queue_operations_link() {

		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");

		// ObjQueuePage.EnterPhytonCode("print(\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		ObjQueuePage.EnterPhytonCode(arrLL.get(1).get(0));
	}

	@Then("User clicks on the run button for Queue Operations link")
	public void user_clicks_on_the_run_button_for_queue_operations_link() {

		ObjQueuePage.clickOnRunButton();
	}

	@Then("User is presented with the result after run button is clicked for Queue Operations link")
	public void user_is_presented_with_the_result_after_run_button_is_clicked_for_queue_operations_link() {

		String actualMsg = ObjQueuePage.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
		// assertEquals(actualMsg, "Implementation in Queue");
		assertEquals(actualMsg, "hello", "Result Matched");
	}

//TestSuite_queue_13
	@Given("User is in a page having an Editor with a Run button to test for Queue Operations page")
	public void user_is_in_a_page_having_an_editor_with_a_run_button_to_test_for_queue_operations_page() {
		ObjQueuePage.navigateToEditorUrl();
		System.out.println("user is in a page having an Editor with a Run button to test Array Page");

	}

	@When("User enters invalid python code in Editor for Queue Operations page")
	public void user_enters_invalid_python_code_in_editor_for_queue_operations_page() throws InterruptedException {
		// ObjQueuePage.InvalidPhytonCode("print\"Implementation in Queue\")");
		ArrayList<ArrayList<String>> arrLLin = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count invalid :" + String.valueOf(arrLLin.size()));
		ObjQueuePage.EnterPhytonCode(arrLLin.get(1).get(1));

	}

	@When("clicks run button for Queue Operations page")
	public void clicks_run_button_for_queue_operations_page() {

		ObjQueuePage.clickOnRunButton();
	}

	@Then("The user gets an error message for Queue Operations page")
	public void the_user_gets_an_error_message_for_queue_operations_page() throws InterruptedException {

		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = ObjQueuePage.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		// assertEquals(actualMsg,"SyntaxError: bad input on line 1", "Result do not
		// match");
		assertEquals(actualMsg, "NameError: name 'hello' is not defined on line 1", "Result do not match");
	}

//TestSuite_queue_14

	@Given("User is in Editor page and navigates to Queue operation page")
	public void user_is_in_editor_page_and_navigates_to_queue_operation_page() {
		ObjQueuePage.navigateToQPracQuesPage();
	}

	@When("User clicks on Practice Questions")
	public void user_clicks_on_practice_questions() {

		ObjQueuePage.clickOnPracticeQuestionsLink();
	}

	@Then("User is directed to Practice page")
	public void user_is_directed_to_practice_page() {

		String Title = ObjQueuePage.getQueuePageTitle();
		LOGGER.info("User is in " + Title);
		assertEquals(Title, "Practice Questions", "Title not matched");

	}
}