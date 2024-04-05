package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.TestContextSetup;

public class purchaseAProductStepDefinition  {
  TestContextSetup testContextSetup;
  LoginPage loginPage;
  InventoryPage inventoryPage;
  CartPage cartPage;
  CheckOutPage checkOutPage;
  CheckOutOverviewPage checkOutOverviewPage;

  CheckOutCompletePage checkOutCompletePage;

  public purchaseAProductStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }


  @Given("I am logged in to the system")
  public void iAmLoggedInToTheSystem() {
    loginPage = testContextSetup.pageObjectManager.getLoginPage();
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
  }
  @When("I select a random product")
  public void iSelectARandomProduct() {
    inventoryPage = loginPage.clickOnSubmitBtn();
    inventoryPage.addRandomProduct();
  }

  @And("I add the product to the cart")
  public void iAddTheProductToTheCart() {
    cartPage = inventoryPage.clickOnCartBtn();
    checkOutPage = cartPage.clickOnCheckoutBtn();
  }

  @And("I add personal data for the purchase")
  public void iAddPersonalDataForThePurchase() {
    checkOutPage.enterFirstName("Juan");
    checkOutPage.enterLastName("Diego");
    checkOutPage.enterPostalCode("000000");
  }

  @And("I proceed to checkout")
  public void iProceedToCheckout() {
    checkOutOverviewPage = checkOutPage.clickOnContinueBtn();
    checkOutCompletePage = checkOutOverviewPage.clickOnFinishBtn();
  }

  @Then("I should see the {string} page")
  public void iShouldSeeThePage(String arg0) {
    Assert.assertEquals(checkOutCompletePage.getSuccessTitleText(), arg0, "Message expected incorrect");
  }

  @After
  public void tearDown() {
    testContextSetup.genericUtils.tearDown();
  }


}
