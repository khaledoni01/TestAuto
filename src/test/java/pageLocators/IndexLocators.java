package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexLocators {

	@FindBy(xpath="//input[@id='username']")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='submit']")
	public WebElement submitBtn;
	
	
	@FindBy(xpath="//a[@href='2ndPage.html']")
	public WebElement secondPageLink;
}
