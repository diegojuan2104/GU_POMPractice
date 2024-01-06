package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class LogoutTests extends BaseTest {
    @Test
    public void LogoutTest(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickOnSubmitBtn();
        inventoryPage.clickOnBuguerMenu();
        inventoryPage.clickOnLogout();

        Assert.assertEquals(loginPage.isDisplayed(), true, "Login page is not displayed");

    }
}
