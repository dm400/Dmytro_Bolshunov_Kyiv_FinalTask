package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailErrorWarning;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrorWarning;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public WebElement getEmailErrorWarning() {
        return emailErrorWarning;
    }

    public WebElement getPasswordErrorWarning() {
        return passwordErrorWarning;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void typeYourEmailInMailField(String email) {
        emailField.sendKeys(email,Keys.TAB);
    }

    public void typeYourPasswordInPassField(String password) {
        passwordField.sendKeys(password);
        build.moveToElement(signInButton).build().perform();
    }
}
