package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionsSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    private static final String QUANTITY_IN_CART = "1";
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
        builder = new Actions(driver);
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);

    }

    @Given("User opens {string}")
    public void userOpensHomepage(final String mainPage) {
        homePage = new PageFactoryManager(driver).getHomePage();
        homePage.openHomePage(mainPage);
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.enterTextInSearchField(keyword);
    }

    @When("User clicks on first wishlist button")
    public void userClicksOnFirstWishlistButton() {
        searchResultsPage = new PageFactoryManager(driver).getSearchResultsPage();
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
        wishlistPage = new PageFactoryManager(driver).getWishlistPage();
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
        searchResultsPage = new PageFactoryManager(driver).getSearchResultsPage();
        searchResultsPage.clickOnFirstSearchedProduct();
    }

    @And("User chooses product`s size")
    public void userChoosesProductSSize() {
        productPage = new PageFactoryManager(driver).getProductPage();
        productPage.clickOnSecondElementOfSizeDropDownMenu();
    }

    @When("User clicks on add to bag button")
    public void userClicksOnAddToBagButton() {
        productPage.clickOnAddToBagButton();
    }

    @Then("User checks if quantity of products in the cart is correct")
    public void userChecksIfQuantityOfProductsInTheCartIsCorrect() {
        homePage = new PageFactoryManager(driver).getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getCartIcon());
        homePage.checkCorrectNumberOfProductsInCart(QUANTITY_IN_CART);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
