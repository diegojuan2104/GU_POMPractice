package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutCompletePage extends BasePage{

    private WebDriver driver;

    @FindBy(css="h2.complete-header")
    private WebElement successTitleText;
    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getSuccessTitleText(){
        WaitUntilElementIsDisplayed(successTitleText);
        return successTitleText.getText();
    }
}
