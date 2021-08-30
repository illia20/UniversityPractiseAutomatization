package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(@class, 'gs-c-promo-heading')]")
    private WebElement headline;

    @FindBy(xpath = "//*[contains(@class, 'gs-c-promo-body')]/ul/li/a")
    private WebElement catLinkHeadline;

    @FindBy(id = "orb-search-q")
    private WebElement searchInput;

    @FindAll(@FindBy(xpath = "//*[contains(@class, 'nw-c-top-stories__secondary-item')]/div/div/div/a"))
    private List<WebElement> secondaryTitles;

    public NewsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getHeadline() {
        return headline;
    }

    public void setHeadline(WebElement headline) {
        this.headline = headline;
    }

    public WebElement getCatLinkHeadline() {
        return catLinkHeadline;
    }

    public void setCatLinkHeadline(WebElement catLinkHeadline) {
        this.catLinkHeadline = catLinkHeadline;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(WebElement searchInput) {
        this.searchInput = searchInput;
    }

    public List<WebElement> getSecondaryTitles() {
        return secondaryTitles;
    }

    public void setSecondaryTitles(List<WebElement> secondaryTitles) {
        this.secondaryTitles = secondaryTitles;
    }

    public String getCategoryOfMain(){
        return catLinkHeadline.getText();
    }

    public void search(String q){
        searchInput.sendKeys(q + Keys.ENTER);
    }

    public String getHeadlineText(){
        return headline.getText();
    }
}
