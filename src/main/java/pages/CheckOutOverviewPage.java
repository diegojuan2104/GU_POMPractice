package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutOverviewPage extends BasePage {

    private WebDriver driver;

    @FindBy(id="finish")
    private WebElement finishBtn;

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CheckOutCompletePage clickOnFinishBtn(){
        finishBtn.click();
        return new CheckOutCompletePage(driver);
    }
}
