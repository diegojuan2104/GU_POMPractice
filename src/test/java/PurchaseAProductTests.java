import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseAProductTests extends BaseTest {
    @Test
    public void purchaseARandomProductTest(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickOnSubmitBtn();
        inventoryPage.addRandomProduct();
        CartPage cartPage = inventoryPage.clickOnCartBtn();
        CheckOutPage checkOutPage = cartPage.clickOnCheckoutBtn();
        checkOutPage.enterFirstName("Juan");
        checkOutPage.enterLastName("Diego");
        checkOutPage.enterPostalCode("000000");
        CheckOutOverviewPage checkOutOverviewPage = checkOutPage.clickOnContinueBtn();
        CheckOutCompletePage checkOutCompletePage = checkOutOverviewPage.clickOnFinishBtn();
        Assert.assertEquals(checkOutCompletePage.getSuccessTitleText(), "Thank you for your order!", "Message expected incorrect");

    }
}
