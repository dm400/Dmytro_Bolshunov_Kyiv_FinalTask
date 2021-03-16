package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionsSteps {
    private static final long DEFAULT_TIMEOUT = 100;
    private static final String QUANTITY_IN_CART = "1";
    private static final String Empty_Cart = "";
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    WishlistPage wishlistPage;
    PageFactoryManager pageFactoryManager;
    Actions builder;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        var options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens {string}")
    public void userOpensHomepage(final String mainPage) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(mainPage);
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.enterTextInSearchField(keyword);
    }

    @When("User clicks on first wishlist button")
    public void userClicksOnFirstWishlistButton() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getFirstWishlistButton());
        searchResultsPage.clickOnWishlistButton();
    }

    @And("User go to wishlist")
    public void userGoToWishlist() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getWishlistButton());
        homePage.clickOnWishlistButton();
    }

    @Then("User checks that the product is on the wishlist")
    public void userChecksThatTheProductIsOnTheWishlist() {
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishlistPage.checkProductAreInWishlist();
    }

    @And("User delete item from wishlist")
    public void userDeleteItemFromWishlist() {
        wishlistPage.deleteItemFromWishlist();
    }

    @And("User checks that item has been deleted from wishlist")
    public void userChecksThatItemHasBeenDeletedFromWishlist() {
        wishlistPage.checkWishlistIsEmpty();
    }

    @And("User clicks on women category button")
    public void userClicksOnWomenCategoryButton() {
        homePage.clickOnWomenCategoryButton();
    }

    @And("User clicks on shopNow button")
    public void userClicksOnShopNowButton() {
        homePage.clickOnShopNowButton();
    }

    @And("User clicks on first product in list")
    public void userClicksOnFirstProductInList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickOnFirstSearchedProduct();
    }

    @And("User chooses product`s size")
    public void userChoosesProductSSize() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnSecondElementOfSizeDropDownMenu();
    }

    @When("User clicks on add to bag button")
    public void userClicksOnAddToBagButton() {
        productPage.clickOnAddToBagButton();
    }

    @Then("User checks if quantity of products in the cart is correct")
    public void userChecksIfQuantityOfProductsInTheCartIsCorrect() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCartIconFilled());
        homePage.checkCorrectNumberOfProductsInCart(QUANTITY_IN_CART);
    }



    @Then("User go to cart page")
    public void userGoToCartPage() {
        homePage.moveCursorTo(homePage.getCartIconFilled());
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.moveCursorTo(homePage.getViewBagButton());
        homePage.clickOnViewBagButton();
    }

    @Then("User delete item from cart")
    public void userDeleteItemFromCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getRemoveFromCartButton());
        cartPage.removeFromCart();
    }

    @And("User checks product has been removed")
    public void userChecksProductHasBeenDeleted() {

        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getCartIconUnfilled());
        Assert.assertEquals(Empty_Cart,homePage.getCartIconUnfilled().getText());
    }

    @When("User delete item from cart`s popup menu")
    public void userDeleteItemFromCartSPopupMenu() {
        homePage.moveCursorTo(homePage.getCartIconFilled());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getDeleteFormCartUsingPopupButton());
        homePage.moveCursorTo(homePage.getDeleteFormCartUsingPopupButton());
        homePage.deleteFromCartUsingPopup();
    }


}
