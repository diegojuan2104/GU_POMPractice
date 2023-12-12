package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class LoginPage extends BasePage {
    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterUsername(String text) {
        WaitUntilElementIsDisplayed(usernameTextField);
        usernameTextField.sendKeys(text);
    }

    public void enterPassword(String text) {
        WaitUntilElementIsDisplayed(passwordTextField);
        passwordTextField.sendKeys(text);
    }

    public InventoryPage clickOnSubmitBtn() {
        WaitUntilElementIsDisplayed(loginBtn);
        loginBtn.click();
        return new InventoryPage(driver);
    }

    public Boolean isDisplayed() {
        return WaitUntilElementsAreDisplayed(Arrays.asList(usernameTextField, passwordTextField, loginBtn));
    }
}
