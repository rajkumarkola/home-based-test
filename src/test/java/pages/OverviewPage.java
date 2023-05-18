package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class OverviewPage extends BaseTest {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(name = "finish")
    private WebElement finishButton;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }

}
