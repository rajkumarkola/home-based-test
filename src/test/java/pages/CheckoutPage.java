package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;

public class CheckoutPage {
    private final WebDriver driver;
    private final ConfigReader configReader = new ConfigReader("src/test/resources/data.json");

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "postalCode")
    private WebElement postalCode;

    @FindBy(name = "continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName() {
        firstName.sendKeys(configReader.getFirstName());
    }

    public void enterLastName() {
        lastName.sendKeys(configReader.getLastName());
    }

    public void enterPostalCode() {
        postalCode.sendKeys(configReader.getPostalCode());
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

}
