package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;

public class InventoryPage extends BasePage {
    WebDriver driver;

    @FindBy(css="button.btn_inventory")
    private List<WebElement> addProductBtnList;

    @FindBy(id="shopping_cart_container")
    private WebElement cartBtn;

    @FindBy(id="react-burger-menu-btn")
    private WebElement burguerBtn;

    @FindBy(id="logout_sidebar_link")
    private WebElement logoutLink;


    public InventoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void addRandomProduct(){
        addProductByIndex(Utils.getRandomNumber(addProductBtnList.size()));
    }


    public void addProductByIndex(int index){
        WaitUntilElementsAreDisplayed(addProductBtnList);
        WebElement randomProduct = addProductBtnList.get(index);
        randomProduct.click();
    }

    public CartPage clickOnCartBtn(){
        WaitUntilElementIsDisplayed(cartBtn);
        cartBtn.click();
        return new CartPage(driver);
    }

    public void clickOnBuguerMenu(){
        WaitUntilElementIsDisplayed(burguerBtn);
        burguerBtn.click();
    }

    public LoginPage clickOnLogout(){
        WaitUntilElementIsDisplayed(logoutLink);
        logoutLink.click();
        return new LoginPage(driver);
    }
}
