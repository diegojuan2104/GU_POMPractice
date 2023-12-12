package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
    @FindBy(id="first-name")
    private WebElement firstNameTextField;

    @FindBy(id="last-name")
    private WebElement lastNameTextField;

    @FindBy(id="postal-code")
    private WebElement postalCodeTextField;

    @FindBy(id="continue")
    private WebElement continueBtn;

    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public  CheckOutOverviewPage clickOnContinueBtn(){
        continueBtn.click();
        return new CheckOutOverviewPage(driver);
    }

    public void enterFirstName(String text) {
        WaitUntilElementIsDisplayed(firstNameTextField);
        firstNameTextField.sendKeys(text);
    }

    public void enterLastName(String text) {
        WaitUntilElementIsDisplayed(lastNameTextField);
        lastNameTextField.sendKeys(text);
    }

    public void enterPostalCode(String text) {
        WaitUntilElementIsDisplayed(postalCodeTextField);
        postalCodeTextField.sendKeys(text);
    }

}
