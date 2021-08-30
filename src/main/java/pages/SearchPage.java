package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div/main/div[1]/div[3]/div/div/ul/li[1]/div/div/div[1]/div[1]/a")
    private WebElement firstArticleTitle;

    public String getFirstArticleTitleText(){
        return firstArticleTitle.getText();
    }

    public WebElement getFirstArticleTitle() {
        return firstArticleTitle;
    }

    public void setFirstArticleTitle(WebElement firstArticleTitle) {
        this.firstArticleTitle = firstArticleTitle;
    }
}
