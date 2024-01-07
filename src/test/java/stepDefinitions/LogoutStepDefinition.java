package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.InventoryPage;
import pages.LoginPage;
import utils.TestContextSetup;

public class LogoutStepDefinition {

  public TestContextSetup testContextSetup;
  public InventoryPage inventoryPage;
  public LoginPage loginPage;

  public LogoutStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("I am logged in to the system with valid {} and {}")
  public void iAmLoggedInToTheSystemWithValidAnd(String username, String password) {

    loginPage = testContextSetup.pageObjectManager.getLoginPage();
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    inventoryPage = loginPage.clickOnSubmitBtn();
  }

  @When("I click on the logout button")
  public void iClickOnTheLogoutButton() {
    inventoryPage.clickOnBuguerMenu();
    inventoryPage.clickOnLogout();
  }

  @Then("I should be redirected to the login page")
  public void iShouldBeRedirectedToTheLoginPage() {
    Assert.assertTrue(loginPage.isDisplayed());
  }

  @After
  public void tearDown() {
    testContextSetup.genericUtils.tearDown();
  }


}
