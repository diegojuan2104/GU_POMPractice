package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "button.cart_button")
    private List<WebElement> removeBtnList;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id="cart_contents_container")
    private WebElement cartListContainer;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void removeAllProducts() {
        removeBtnList.forEach(
                WebElement::click
        );
    }

    public CheckOutPage clickOnCheckoutBtn() {
        WaitUntilElementIsDisplayed(checkoutBtn);
        checkoutBtn.click();
        return new CheckOutPage(driver);
    }

    public Boolean cartListIsEmpty(){
        WaitUntilElementIsDisplayed(cartListContainer);
        return removeBtnList.isEmpty();
    }
}
