import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCardTest {

    WebDriver driver;

    @BeforeTest
    public void setupDriver () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void cleanDriver() {
        driver.quit();  // close window
    }

    @Test
    public void buyDress() {
        driver.get("http://automationpractice.com/index.php");

        WebElement dressButton = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a"));
        dressButton.click();

        WebElement eveningDressButton = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a/ul/li[2]"));
    }
}
