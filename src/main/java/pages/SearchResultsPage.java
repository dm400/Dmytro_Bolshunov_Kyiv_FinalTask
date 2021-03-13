package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private WebElement firstWishlistButton;

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    private WebElement firstSearchedProduct;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstWishlistButton() {
        return firstWishlistButton;
    }

   public void clickOnFirstSearchedProduct() {
        firstSearchedProduct.click();
   }

    public void clickOnWishlistButton() {
        firstWishlistButton.click();
    }
}
