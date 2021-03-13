package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[text()='Add to bag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizeSelectDropDown;

    @FindBy(xpath = "//select[@data-id='sizeSelect']//option[@value]")
    private List<WebElement> elementsFromSizeSelectDropDownMenu;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToBagButton() {
        addToBagButton.click();
    }

    public void clickOnSizeSelectDropDown() {
        sizeSelectDropDown.click();
    }

    public void clickOnSecondElementOfSizeDropDownMenu() {
        elementsFromSizeSelectDropDownMenu.get(1).click();
    }
}
