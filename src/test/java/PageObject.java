import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageObject {

    WebDriver driver;
    WebDriverWait wait;
    public static final String baseUrl = "https://www.ikea.com/ua/uk/";

    @BeforeTest
    public void setUpDriver () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait (driver, 10);
    }

    @AfterTest
    public void cleanDriver() {
        driver.quit();
    }
    @Test
    public void login() {
        HomePage homePage = new HomePage(driver);
        openIkea();
        homePage.getLoginButton().click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("alyona", "some@email.com");
        Assert.assertTrue(loginPage.getAllertText().contains("Сталася помилка:"));
    }

    private void openIkea () {
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
    }

}
