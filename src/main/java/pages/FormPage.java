package pages;

import conf.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    private WebDriver driver;

    public FormPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class='embed-content-container']/div/textarea")
    private WebElement textInput;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='text-input']/div[1]/div/input")
    private WebElement nameInput;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='text-input']/div[2]/div/input")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='text-input']/div[3]/div/input")
    private WebElement contactInput;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='text-input']/input")
    private WebElement locationInput;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[5]/label/input[@type='checkbox']")
    private WebElement dpCB;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[6]/label/input[@type='checkbox']")
    private WebElement termsCB;

    @FindBy(xpath = "//div[@class='button-container']/button[@class='button']")
    private WebElement submitButton;

    public void load(){
        driver.get(ConfProperties.getProperty("formpage"));
    }

    public void submit(){submitButton.click();}

    public void writeText(String q){
        textInput.sendKeys(q);
    }

    public void writeName(String q){
        nameInput.sendKeys(q);
    }

    public void clickTermsBox(){
        termsCB.click();
    }

    public String getTextValue(){
        return textInput.getAttribute("value");
    }

    public String getNameValue(){
        return nameInput.getAttribute("value");
    }

    public WebElement getTextInput() {
        return textInput;
    }

    public void setTextInput(WebElement textInput) {
        this.textInput = textInput;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public void setNameInput(WebElement nameInput) {
        this.nameInput = nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(WebElement emailInput) {
        this.emailInput = emailInput;
    }

    public WebElement getContactInput() {
        return contactInput;
    }

    public void setContactInput(WebElement contactInput) {
        this.contactInput = contactInput;
    }

    public WebElement getLocationInput() {
        return locationInput;
    }

    public void setLocationInput(WebElement locationInput) {
        this.locationInput = locationInput;
    }

    public WebElement getDpCB() {
        return dpCB;
    }

    public void setDpCB(WebElement dpCB) {
        this.dpCB = dpCB;
    }

    public WebElement getTermsCB() {
        return termsCB;
    }

    public void setTermsCB(WebElement termsCB) {
        this.termsCB = termsCB;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
}
