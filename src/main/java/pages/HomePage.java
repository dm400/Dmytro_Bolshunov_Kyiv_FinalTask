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
    private WebElement cartIconFilled;

    @FindBy(xpath = "//a[@href='https://www.asos.com/bag?ctaref=mini%20bag']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//span[@type='bagUnfilled']")
    private WebElement cartIconUnfilled;

    @FindBy(xpath = "//button[@aria-label='Delete this item']")
    private WebElement deleteFormCartUsingPopupButton;

    public WebElement getDeleteFormCartUsingPopupButton() {
        return deleteFormCartUsingPopupButton;
    }
    public WebElement getCartIconUnfilled() {
        return cartIconUnfilled;
    }
    public WebElement getViewBagButton() {
        return viewBagButton;
    }
    public void clickOnViewBagButton(){
        viewBagButton.click();
    }

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
        Assert.assertEquals(quantityOfProducts, cartIconFilled.getText());
    }

    public WebElement getCartIconFilled() {
        return cartIconFilled;
    }

    public void moveCursorTo(WebElement element){
        build.moveToElement(element).build().perform();
    }

    public void deleteFromCartUsingPopup() {
        deleteFormCartUsingPopupButton.click();
    }
}
