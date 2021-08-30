package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "user-identifier-input")
    private WebElement loginInput;

    @FindBy(id = "password-input")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public void clickSubmit(){submitButton.click();}

    public void writePassword(String p){
        passwordInput.sendKeys(p);
    }

    public void writeLogin(String p){
        loginInput.sendKeys(p);
    }

    public WebElement getLoginInput() {
        return loginInput;
    }

    public void setLoginInput(WebElement loginInput) {
        this.loginInput = loginInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(WebElement passwordInput) {
        this.passwordInput = passwordInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
}
