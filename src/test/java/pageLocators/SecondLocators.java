package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondLocators {

	@FindBy(xpath="//input[@value='Alert Button']")
	public WebElement alertBtn;
}
