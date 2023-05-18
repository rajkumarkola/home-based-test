package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
    public LoginPage loginPage;

    @Test
    public void testInvalidLogin() {
        // Perform login
        loginPage = new LoginPage(driver);
        loginPage.login(configReader.getInvalidUsername(), configReader.getInvalidPassword());
        Assert.assertEquals(loginPage.getErrorMessage().trim(),
                "Epic sadface: You can only access '/checkout-complete.html' when you are logged in.");
    }
}