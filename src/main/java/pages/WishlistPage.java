package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage {

    @FindBy(xpath = "//div[@class='customerItemsProductTile_19AHL']")
    List<WebElement> productsInWishlist;

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private WebElement deleteFromWishlistButton;

    @FindBy(xpath = "//h2[text()='You have no Saved Items']")
    private WebElement noElementsInWishlistText;

    public WebElement getDeleteFromWishlistButton() {
        return deleteFromWishlistButton;
    }

    public WebElement getNoElementsInWishlistText() {
        return noElementsInWishlistText;
    }

    public String getExpResNoElementsInWishlist() {
        return expResNoElementsInWishlist;
    }

    private final String expResNoElementsInWishlist = "You have no Saved Items";

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public void checkProductAreInWishlist() {
        Assert.assertTrue(productsInWishlist.size() > 0);
    }

    public void deleteItemFromWishlist() {
        deleteFromWishlistButton.click();
    }

    public void checkWishlistIsEmpty() {
        Assert.assertTrue(productsInWishlist.size() == 0);
    }
}
