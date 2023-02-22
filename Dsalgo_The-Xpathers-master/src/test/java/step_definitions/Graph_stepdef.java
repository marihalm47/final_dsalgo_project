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
import page_objects.SigninPage;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class Graph_stepdef {

	WebDriver driver = DriverManager.getDriver();
	SigninPage SignPage = SigninPage.getInstance();
	HomePage homePage = HomePage.getInstance();
	GraphPage objgraphpg = GraphPage.getInstance();
	common_utils objCommounUtils = new common_utils();
	String enterCode;

	private static final Logger LOGGER = LogManager.getLogger(Graph_stepdef.class);

	public Graph_stepdef() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	// @TestDemo_Graph_01
	@Given("After signin user is in home page")
	public void after_signin_user_is_in_home_page() throws InterruptedException {

		driver.get(Constants.SIGNIN_URL);
		driver.manage().window().maximize();
		SignPage.Signin(Constants.USERNAME, Constants.PASSWORD);

		objgraphpg.navigateToHomePage();
		System.out.println("User is in Queue Home Page");
	}

	@When("User clicks on get started button or dropdown for graph")
	public void user_clicks_on_get_started_button_or_dropdown_for_graph() throws InterruptedException {

		objgraphpg.graphgetstartedbutton();
	}

	@Then("user directed to the graph page")
	public void user_directed_to_the_graph_page() {
		System.out.println("user directed to the graph page");

	}

	// @TestDemo_Graph_02
	@Given("User in graph page")
	public void user_in_graph_page() {

		String Title = objgraphpg.getGraphPageTitle();
		LOGGER.info("Title of current page is : " + Title);
		assertEquals(Title, "Graph", "Title not matched");
	}

	@When("User clicks on graph link button")
	public void user_clicks_on_graph_link_button() throws InterruptedException {

		objgraphpg.Clickongraphlink();
	}

	@Then("User should be directed to graph link page")
	public void user_should_be_directed_to_graph_link_page() {
		System.out.println("User should be directed to graph link page");

	}

//@TestDemo_Graph_03
	@Given("User is in graph link page")
	public void user_is_in_graph_link_page() {
		String Title = objgraphpg.getGraphPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Graph", "Title not matched");

	}

	@When("User clicks on Tryhere link for graph link page")
	public void user_clicks_on_tryhere_link_for_graph_link_page() throws InterruptedException {

		objgraphpg.Clickontryherebutton();
	}

	@Then("User navigates to Editor page to enter valid python code for graph link page")
	public void user_navigates_to_editor_page_to_enter_valid_python_code_for_graph_link_page() {
		/*
		 * String Title = objgraphpg.getGraphPageTitle();
		 * LOGGER.info("Title of current page is :" + Title); assertEquals(Title,
		 * "Assessment", "Title not matched");
		 * 
		 * //objgraphpg.EnterPhytonCode("print(\"Graph Page\")");
		 * ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		 * LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		 * objgraphpg.txtCodeArea_senkeys(arrLL.get(1).get(0));
		 */

		String Title = objgraphpg.getGraphPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");

		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		objgraphpg.EnterPhytonCode(arrLL.get(1).get(0));
	}

	@Then("User clicks on the run button for graph link page")
	public void user_clicks_on_the_run_button_for_graph_link_page() {

		objgraphpg.clickOnRunButton();
	}

	@Then("User is presented with the result after run button is clicked for graph link page")
	public void user_is_presented_with_the_result_after_run_button_is_clicked_for_graph_link_page() {

		String actualMsg = objgraphpg.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, "hello", "Result Matched");
	}

	// @TestDemo_Graph_04

	@Given("User is in a page having an Editor with a Run button to test for graph link page")
	public void user_is_in_a_page_having_an_editor_with_a_run_button_to_test_for_graph_link_page() {
		System.out.println("The user is in a page having an Editor with a Run button to test for graph link page");
		objgraphpg.navigateToGraphEditorUrl();

	}

	@When("User enters invalid python code for graph link page")
	public void user_enters_invalid_python_code_for_graph_link_page() throws InterruptedException {
		// objgraphpg.InvalidPhytonCode("print\"Graph Page\")");
		ArrayList<ArrayList<String>> arrLLin = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count invalid :" + String.valueOf(arrLLin.size()));
		objgraphpg.EnterPhytonCode(arrLLin.get(1).get(1));
	}

	@When("clicks run button for graph link page")
	public void clicks_run_button_for_graph_link_page() {
		objgraphpg.clickOnRunButton();

	}

	@Then("The user gets an error message for graph link page")
	public void the_user_gets_an_error_message_for_graph_link_page() throws InterruptedException {

		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = objgraphpg.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		assertEquals(actualMsg, "NameError: name 'hello' is not defined on line 1", "Result do not match");
	}

	// @TestDemo_Graph_05
	@Given("User in editor page and navigates to the graph page for graph representations")
	public void user_in_editor_page_and_navigates_to_the_graph_page_for_graph_representations()
			throws InterruptedException {
		objgraphpg.navigateTographPage();

	}

	@When("User clicks on graph representations link")
	public void user_clicks_on_graph_representations_link() {
		objgraphpg.clickOngraphrepresentations();

	}

	@Then("User should be redirected to graph representations")
	public void user_should_be_redirected_to_graph_representations() {
		System.out.println("User should be redirected to graph representations");

	}

	// TestDemo_Graph_06
	@Given("User is in graph representations")
	public void user_is_in_graph_representations() throws InterruptedException {

		objgraphpg.clickOngraphrepresentations();
		String Title = objgraphpg.getGraphPageTitle();
		LOGGER.info("Title of current page is " + Title);
		assertEquals(Title, "Graph Representations", "Title matched");
	}

	@When("User clicks on Tryhere link for graph representations")
	public void user_clicks_on_tryhere_link_for_graph_representations() throws InterruptedException {
		objgraphpg.Clickontryherebutton();

	}

	@Then("User navigates to Editor page to enter valid python code for graph representations")
	public void user_navigates_to_editor_page_to_enter_valid_python_code_for_graph_representations()
			throws InterruptedException {
		String Title = objgraphpg.getGraphPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title not matched");

		ArrayList<ArrayList<String>> arrLL = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count :" + String.valueOf(arrLL.size()));
		objgraphpg.EnterPhytonCode(arrLL.get(1).get(0));

		// objgraphpg.EnterPhytonCode("print(\"Graph Representations\")");
	}

	@Then("User clicks on the run button for graph representations")
	public void user_clicks_on_the_run_button_for_graph_representations() throws InterruptedException {
		objgraphpg.clickOnRunButton();
		Thread.sleep(1000);

	}

	@Then("The user is presented with the result after run button is clicked for graph representations")
	public void the_user_is_presented_with_the_result_after_run_button_is_clicked_for_graph_representations()
			throws InterruptedException {

		/*
		 * objgraphpg.navigateTographPage(); String Title =
		 * objgraphpg.getActualResult(); LOGGER.info("Actual result  :" + Title);
		 * assertEquals(Title, "Graph Representations", "Result Match");
		 */
		System.out.println("user is presented with the result after run button is clicked for graph representations");

		String actualMsg = objgraphpg.getActualResult();
		LOGGER.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, "hello");
	}

	// @TestDemo_Graph_07
	@Given("User is in a page having an Editor with a Run button to test for graph representations")
	public void user_is_in_a_page_having_an_editor_with_a_run_button_to_test_for_graph_representations() {

		System.out
				.println("The user is in a page having an Editor with a Run button to test for graph representations");
		objgraphpg.navigateToGraphEditorUrl();

	}

	@When("User enters invalid python code in Editor for graph representations")
	public void user_enters_invalid_python_code_in_editor_for_graph_representations() throws InterruptedException {

		// objgraphpg.InvalidPhytonCode("print\"graph representations\")");
		ArrayList<ArrayList<String>> arrLLin = objCommounUtils.readExcelData();
		LOGGER.info("Arraylist count invalid :" + String.valueOf(arrLLin.size()));
		objgraphpg.EnterPhytonCode(arrLLin.get(1).get(1));
	}

	@When("clicks run button for graph representations")
	public void clicks_run_button_for_graph_representations() {
		objgraphpg.clickOnRunButton();

	}

	@Then("The user gets an error message for graph representations")
	public void the_user_gets_an_error_message_for_graph_representations() throws InterruptedException {
		LOGGER.info("Invalid code when clicked on run button");
		String actualMsg = objgraphpg.getErrorText();
		LOGGER.info("Error message for invalid python code is" + actualMsg);
		assertEquals(actualMsg, "NameError: name 'hello' is not defined on line 1", "Result do not match");

	}

	// @TestDemo_Graph_08
	@Given("User is in Editor page and navigates to graph representations page")
	public void user_is_in_editor_page_and_navigates_to_graph_representations_page() {
		objgraphpg.navigateTographPracQuesPage();

	}

	@When("User clicks on Practice Questions from graph representations page")
	public void user_clicks_on_practice_questions_from_graph_representations_page() {

		objgraphpg.clickOnPracticeQuestionsLink();
	}

	@Then("User is directed to the Practice page")
	public void user_is_directed_to_the_practice_page() {
		String Title = objgraphpg.getGraphPageTitle();
		LOGGER.info("User is in " + Title);
		assertEquals(Title, "Practice Questions", "Title not matched");

	}

}