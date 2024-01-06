package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;

public class RemoveProductTests extends BaseTest  {

    @Test
    public void removeAllOfTheProducts(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickOnSubmitBtn();
        inventoryPage.addProductByIndex(0);
        inventoryPage.addProductByIndex(2);
        inventoryPage.addProductByIndex(4);
        CartPage cartPage = inventoryPage.clickOnCartBtn();
        cartPage.removeAllProducts();
        Assert.assertEquals(cartPage.cartListIsEmpty(), true, "Cart is not empty");
    }
}
