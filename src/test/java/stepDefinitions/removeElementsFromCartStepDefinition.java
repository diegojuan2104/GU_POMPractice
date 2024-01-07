package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.TestContextSetup;

public class removeElementsFromCartStepDefinition {

  TestContextSetup testContextSetup;
  LoginPage loginPage;
  InventoryPage inventoryPage;
  CartPage cartPage;

  public removeElementsFromCartStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("I am logged in to the system to select items random items")
  public void iAmLoggedInToTheSystemToSelectItemsRandomItems() {
    loginPage = testContextSetup.pageObjectManager.getLoginPage();
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    inventoryPage = loginPage.clickOnSubmitBtn();
  }
    @Given("I have added {int} different elements to the shopping cart")
    public void iHaveAddedDifferentElementsToTheShoppingCart(int arg0) {
      for (int i = 0; i < arg0; i++) {
        inventoryPage.addProductByIndex(i);
      }
    }

    @When("I go to the cart page")
    public void iGoToTheCartPage() {
      cartPage = inventoryPage.clickOnCartBtn();
    }

    @And("I remove all items from the cart")
    public void iRemoveAllItemsFromTheCart() {
      cartPage.removeAllProducts();
    }

    @Then("the shopping cart should be empty")
    public void theShoppingCartShouldBeEmpty() {
      Assert.assertTrue(cartPage.cartListIsEmpty(),"Cart is not empty");
    }
  @After
  public void tearDown() {
    testContextSetup.genericUtils.tearDown();
  }


}
