import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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

}
