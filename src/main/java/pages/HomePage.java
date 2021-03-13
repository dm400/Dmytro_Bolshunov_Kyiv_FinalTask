package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@type='heartUnfilled']")
    WebElement wishlistButton;

    @FindBy(xpath = "//a[text()='WOMEN']")
    private WebElement womenCategoryButton;

    @FindBy(xpath = "//div[@class='moment__buttons']//span[text()='SHOP NOW']")
    private WebElement shopNowButton;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement cartIcon;

    public WebElement getWishlistButton() {
        return wishlistButton;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public void enterTextInSearchField(String text) {
        getSearchField().click();
        getSearchField().sendKeys(text, Keys.ENTER);
    }

    public void IsSearchPageVisible() {
        getSearchField().isDisplayed();
    }

    public void clickOnWishlistButton() {
        wishlistButton.click();
    }

    public void clickOnWomenCategoryButton() {
        womenCategoryButton.click();
    }

    public void clickOnShopNowButton() {
        shopNowButton.click();
    }

    public void checkCorrectNumberOfProductsInCart(String quantityOfProducts) {
        Assert.assertEquals(cartIcon.getText(), quantityOfProducts);
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }
}
