package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

  public WebDriver driver;
  public CartPage cartPage;
  public LoginPage loginPage;
  public CheckOutCompletePage checkOutCompletePage;
  public CheckOutOverviewPage checkOutOverviewPage;
  public CheckOutPage checkOutPage;
  public InventoryPage inventoryPage;


  public PageObjectManager(WebDriver driver) {
    this.driver = driver;
  }

  public CartPage getCartPage() {
    return new CartPage(driver);
  }

  public LoginPage getLoginPage() {
    return new LoginPage(driver);
  }

  public CheckOutCompletePage getCheckOutCompletePage() {
    return new CheckOutCompletePage(driver);
  }

  public CheckOutOverviewPage getCheckOutOverviewPage() {
    return new CheckOutOverviewPage(driver);
  }

  public CheckOutPage getCheckOutPage() {
    return new CheckOutPage(driver);
  }

  public InventoryPage getInventoryPage() {
    return new InventoryPage(driver);
  }



}
