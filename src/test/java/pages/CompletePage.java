package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompletePage {

    private final WebDriver driver;

    @FindBy(className = "pony_express")
    private WebElement successImage;

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    public CompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTheSuccessSymbol() {
        Assert.assertTrue(successImage.isDisplayed(), "Success Image not Displayed");
    }

    public void verifyThankYouMessage() {
        Assert.assertEquals(thankYouMessage.getText().trim(), "Thank you for your order!");
    }
}
