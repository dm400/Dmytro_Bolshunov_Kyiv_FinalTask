package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeFromCartButton;

    public WebElement getRemoveFromCartButton() {
        return removeFromCartButton;
    }
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void removeFromCart() {
        removeFromCartButton.click();
    }


}
