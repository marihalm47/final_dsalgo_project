package page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import constants.Constants;
import webdriver_manager.DriverManager;

public class Datastructure {
	
	private static Datastructure loginpageInstance;
 
	private Datastructure() {
		
		}
	
	//this method prevents second object creation for the same type,Singleton pattern lazy loading
	
	public static Datastructure getInstance()
	
	{
		if (loginpageInstance==null) {
			loginpageInstance = new Datastructure();

		}
       
		return loginpageInstance;	
	}

	@FindBy(xpath="//a[@href='/home']")WebElement Dsalgoportal_link;
	@FindBy(xpath="//a[@href='data-structures-introduction']")WebElement Datastructure_intro_link;
	@FindBy(xpath="//a[@href=\"time-complexity\"]")WebElement Timecomplexity_link;
	@FindBy(xpath="//a[@href='/tryEditor']")WebElement Tryeditor_link;
	@FindBy(xpath="//button[@type='button']")WebElement Runbtn_link;
	@FindBy(xpath="//a[@href=\'/data-structures-introduction/practice\']")WebElement Practice_Questions_link;
	@FindBy(xpath="//div[@class='CodeMirror cm-s-default CodeMirror-focused']/div[1]//textarea")WebElement Texteditor_enterpythoncode;
	@FindBy(xpath = "//pre[@id='output']")WebElement CodeOutput_link;
	@FindBy(xpath = "//pre[@id='content']")WebElement PQ_Error_page;
	
	
	public void Tryeditor_link()
	{
		Actions actionTry = new Actions(DriverManager.getDriver());
		actionTry.scrollToElement(Tryeditor_link).click(Tryeditor_link);
		actionTry.perform();
	}

	public void Runbtn_link () {
		Runbtn_link.click();
	}
	
	public String CodeOutput_link() {
		return CodeOutput_link.getText();
	}
	
	public void Texteditor_enterpythoncode(String strValue) {
		Texteditor_enterpythoncode.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Texteditor_enterpythoncode.sendKeys(strValue);
	}
	
	public void Dsalgoportal_link() {
	
		Dsalgoportal_link.click();
	}
	
	public void Datastructure_intro_link() {
		
		Datastructure_intro_link.click();
	}
		
	public void Timecomplexity_link() {
		
		Timecomplexity_link.click();

	}
	
   public void PQ_Error_page() {
		
	   PQ_Error_page.click();

	}
	
   public void Practice_Questions_link() {
	
		Practice_Questions_link.click();
}

   //public void navi_to_pracpage() {
	 //  driver.get(Constants.Timecomplexitypage);
   }