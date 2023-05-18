package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    public LoginPage loginPage;

    @Test
    public void testLogin() {
        // Perform login
        loginPage = new LoginPage(driver);
        loginPage.login(configReader.getUsername(), configReader.getPassword());
        Assert.assertEquals(loginPage.verifyLogo(), "Swag Labs");
    }
}