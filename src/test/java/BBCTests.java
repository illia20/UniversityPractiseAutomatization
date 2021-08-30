import conf.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.util.*;

public class BBCTests {
    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    SearchPage searchPage;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        newsPage = new NewsPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        login();
    }

    private void login(){
        homePage.load();
        homePage.clickLogin();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginInput()));
        loginPage.writeLogin(ConfProperties.getProperty("login"));
        loginPage.writePassword(ConfProperties.getProperty("password"));
        loginPage.clickSubmit();
        System.out.println("Login - OK");
    }

    @BeforeMethod
    public void loadBBC(){
        homePage.load();
    }

    @Test
    public void checkHeadline(){
        homePage.clickNews();
        System.out.println("Clicked News - OK");
        wait.until(ExpectedConditions.visibilityOf(newsPage.getHeadline()));
        String actual = newsPage.getHeadlineText();
        System.out.println("Get Headline Text - OK");
        String expected = ConfProperties.getProperty("headlinetext");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkSecondaryTitle(){
        homePage.clickNews();
        System.out.println("Clicked News - OK");
        wait.until(ExpectedConditions.visibilityOf(newsPage.getHeadline()));
        List<String> titles = new ArrayList<String>();
        List<String> expected = Arrays.asList(ConfProperties.getProperty("secondarytitles").split("!"));

        for(var article : newsPage.getSecondaryTitles()){
            String title = article.getText();
            titles.add(title);
        }
        System.out.println("Get Secondary Articles - OK");
        boolean present = true;
        for(var exp : expected){
            present = titles.contains(exp);
        }

        Assert.assertTrue(present);
    }

    @Test
    public void checkFirstArticleName(){
        homePage.clickNews();
        System.out.println("Clicked News - OK");
        wait.until(ExpectedConditions.visibilityOf(newsPage.getCatLinkHeadline()));
        String category = newsPage.getCategoryOfMain();
        System.out.println("Get Category - OK");
        newsPage.search(category);
        System.out.println("Search Input - OK");
        wait.until(ExpectedConditions.visibilityOf(searchPage.getFirstArticleTitle()));
        String actual = searchPage.getFirstArticleTitleText();
        System.out.println("Get 1st Article - OK");
        String expected = ConfProperties.getProperty("searchtitle1");
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
