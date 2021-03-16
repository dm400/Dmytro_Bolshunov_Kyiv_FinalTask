package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private WebElement firstWishlistButton;

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    private WebElement firstSearchedProduct;

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    private List<WebElement> listOfFoundResults;

    @FindBy(xpath = "//div[text()='Sort']")
    private WebElement sortMenuButton;

    @FindBy(xpath = "//div[@class='_2pwX7b9' and text()='Size']")
    private WebElement sizeMenuButton;

    @FindBy(xpath = "//label[@class='_1ikeRVG' and text()='L']")
    private WebElement lSizeMenuItem;

    @FindBy(xpath = "//li[@id='plp_web_sort_price_high_to_low']")
    private WebElement descendingSortMenuItem;

    @FindBy(xpath = "//span[@class='_16nzq18']")
    private WebElement productPrice;

    @FindBy(xpath = "//span[@class='_16nzq18']")
    private List<WebElement> listOfProductPrices;

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

    public void checkOfSearchResults(String searchWord) {
        for (WebElement product : listOfFoundResults) {
            Assert.assertTrue(product.getText().contains(searchWord));
        }
    }

    public void clickOnSortMenuButton() {
        sortMenuButton.click();
    }

    public void clickOnDescendingSortMenuItem() {
        descendingSortMenuItem.click();
    }

    public static double takePriceFromText(String priceInText) {
        priceInText = priceInText.substring(1);
        return Double.parseDouble(priceInText);
    }

    public void checkIfDescendingSortIsCorrect() {
        String testPrice = productPrice.getText();
        for(WebElement price : listOfProductPrices) {
            Assert.assertTrue(takePriceFromText(price.getText()) <= takePriceFromText(testPrice));
            testPrice = price.getText();
        }
    }
}
