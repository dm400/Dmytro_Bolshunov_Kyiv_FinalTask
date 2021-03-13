package manager;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;
    Actions builder;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
        builder = new Actions(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public WishlistPage getWishlistPage() { return new WishlistPage(driver);}

}
