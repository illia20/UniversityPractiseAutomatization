package pages;

import conf.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(@class, 'orb-nav-newsdotcom')]")
    private WebElement newsLink;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "mybbc-wrapper")
    private WebElement loginButton;

    public WebElement getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(WebElement newsLink) {
        this.newsLink = newsLink;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(WebElement loginButton) {
        this.loginButton = loginButton;
    }

    public void load(){
        driver.get(ConfProperties.getProperty("bbcpage"));
    }

    public void clickNews(){
        newsLink.click();
    }

    public void clickLogin(){loginButton.click();}
}
