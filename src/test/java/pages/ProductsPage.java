package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;
    @FindBy(css = ".inventory_item_price")
    private List<WebElement> productPrices;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public double getLeastPrice() {
        double leastPrice = Double.MAX_VALUE;
        for (WebElement priceElement : productPrices) {
            String priceString = priceElement.getText().replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceString);
            if (price < leastPrice) {
                leastPrice = price;
            }
        }
        return leastPrice;
    }

    public void addToCartByPrice(double price) {
        int index = -1;
        for (int i = 0; i < productPrices.size(); i++) {
            String priceString = productPrices.get(i).getText().replaceAll("[^\\d.]", "");
            double currentPrice = Double.parseDouble(priceString);
            if (currentPrice == price) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            addToCartButtons.get(index).click();
        }
    }

    public void clickOnShoppingCart() {
        shoppingCart.click();
    }
}