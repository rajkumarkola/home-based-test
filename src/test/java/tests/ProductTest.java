package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProductTest extends BaseTest {
    public LoginPage loginPage;
    public CartPage cartsPage;
    public ProductsPage productsPage;
    public CheckoutPage checkoutPage;
    public OverviewPage overviewPage;
    public CompletePage completePage;

    @Test
    public void testAddHighestPriceProductToCart() {

        loginPage = new LoginPage(driver);
        loginPage.login(configReader.getUsername(), configReader.getPassword());
        productsPage = new ProductsPage(driver);
        productsPage.addToCartByPrice(productsPage.getLeastPrice());
        productsPage.clickOnShoppingCart();

        cartsPage = new CartPage(driver);
        cartsPage.clickOnCheckoutButton();

        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterPostalCode();
        checkoutPage.clickOnContinueButton();

        overviewPage = new OverviewPage(driver);
        Assert.assertEquals(overviewPage.getPageTitle().trim(), "Checkout: Overview",
                "Overview Page Title doesn't match");
        overviewPage.clickOnFinishButton();

        completePage = new CompletePage(driver);
        completePage.verifyTheSuccessSymbol();
        completePage.verifyThankYouMessage();
    }
}
