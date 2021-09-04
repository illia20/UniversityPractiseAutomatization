import conf.ConfProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class BBCFormTests {
    public WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    LoginPage loginPage;
    FormPage formPage;
    static JavascriptExecutor js;
    private WebDriverWait wait;
    String user = "Tester";
    String text = "Text";

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        newsPage = new NewsPage(driver);
        loginPage = new LoginPage(driver);
        formPage = new FormPage(driver);
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        login();
    }

    @BeforeMethod
    public void loadForm(){
        formPage.load();
        js.executeScript("arguments[0].scrollIntoView();", formPage.getTextInput());
        System.out.println("Form loaded - OK");
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

    @Test
    public void checkEmptyName(){
        formPage.writeText(text);
        System.out.println("Text - OK");
        formPage.clickTermsBox();
        System.out.println("CheckBox - OK");
        formPage.submit();
        System.out.println("Submit - Clicked");
        String textFromTextField = formPage.getTextValue();
        Assert.assertEquals(textFromTextField, text);
    }

    @Test
    public void checkEmptyText(){
        formPage.writeName(user);
        System.out.println("Name - OK");
        formPage.clickTermsBox();
        System.out.println("CheckBox - OK");
        formPage.submit();
        System.out.println("Submit - Clicked");
        String textFromNameField = formPage.getNameValue();
        Assert.assertEquals(textFromNameField, user);
    }

    @Test
    public void checkEmptyCB(){
        formPage.writeText(text);
        System.out.println("Text - OK");
        formPage.writeName(user);
        System.out.println("Name - OK");
        formPage.submit();
        System.out.println("Submit - Clicked");
        String textFromNameField = formPage.getNameValue();
        Assert.assertEquals(textFromNameField, user);
    }

    @Test
    public void checkTextTooLong(){
        StringBuilder stringBuilder = new StringBuilder("aaaaaaaaaa");
        for(int i = 10; i < 500; i += 10)
            stringBuilder.append("aaaaaaaaaa");

        stringBuilder.append("a"); // length = 501

        formPage.writeText(stringBuilder.toString());
        System.out.println("Text - OK");
        formPage.writeName(user);
        System.out.println("Name - OK");
        formPage.clickTermsBox();
        System.out.println("CheckBox - OK");
        formPage.submit();
        System.out.println("Submit - Clicked");
        String textFromNameField = formPage.getNameValue();
        Assert.assertEquals(textFromNameField, user);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
