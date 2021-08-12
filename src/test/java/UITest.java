import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;

public class UITest {

    WebDriver driver;
    private final String baseUrl = "https://www.ikea.com/ua/uk/";
    String STANDART_USER_LOGIN = "standard_user";
    String PASSWORD = "secret_sauce";
    String expectedResult = "https://www.saucedemo.com/inventory.html";
    String expectedErrorText = "Epic sadface: Sorry, this user has been locked out.";

    @BeforeClass
    public void setUpDriver() {
    }

    @BeforeTest
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void cleanDriver() {
        driver.quit();  // close window
    }

    @Test
    public void myUITest() {
        driver.get(baseUrl);
        //  driver.close(); close tab
    }

    @Test
    public void myUITest2() {
        driver.get(baseUrl);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(currentUrl, "https://www.ikea.com/ua/uk/", "Error is not as expected");
    }

    @Test
    public void myUITest3() {
        driver.get(baseUrl);
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
    //    Assert.assertEquals(currentTitle, "404 - Ой! Щось пішло не так :( - IKEA", "404 - Ой! Щось пішло не так :( - IKEA");
        Assert.assertTrue(currentTitle.contains("IKEA"));
    }

    @Test
    public void myUITest4() {
        driver.navigate().to("https://www.ikea.com/ua/uk/");
        driver.navigate().to("https://www.ikea.com/ua/uk/temp");
        driver.navigate().back();
        driver.navigate().refresh();
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
        Assert.assertTrue(currentTitle.contains("IKEA"));
    }

    @org.testng.annotations.Test
    public void standartUserLoginTest() {
        openSource();

        login(STANDART_USER_LOGIN, PASSWORD);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult, "User did not login");
    }

    private void login(String login, String password) {
        WebElement loginField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        loginField.sendKeys(STANDART_USER_LOGIN);
        passwordField.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test
    public void logout() throws InterruptedException {
        openSource();
        login(STANDART_USER_LOGIN,PASSWORD);
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
        Thread.sleep(500);
        logOut.click();
        Assert.assertFalse(driver.getCurrentUrl().contains(expectedResult));
    }

    private void openSource() {
        driver.navigate().to("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    @Test
    public void lockedOutUser() {
        openSource();
        login(STANDART_USER_LOGIN,PASSWORD);
        WebElement errorText = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
        String actualErrorText = errorText.getText();

        Assert.assertEquals(actualErrorText, expectedErrorText, "Message is incorrect");

    }
}
