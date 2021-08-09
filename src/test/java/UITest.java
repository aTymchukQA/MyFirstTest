import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UITest {

    WebDriver driver;
    private final String baseUrl = "https://www.ikea.com/ua/uk/temp";

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

}
