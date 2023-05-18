package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

public class BaseTest {
    public WebDriver driver;
    ConfigReader configReader = new ConfigReader("src/test/resources/data.json");

    @Step("Start the application")
    @BeforeMethod
    public void setUp() {
        // Set up the WebDriver instance (in this example, ChromeDriver)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Read configuration from XML file
        driver.get(configReader.getUrl());
    }

    @Step("Stop the application")
    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
