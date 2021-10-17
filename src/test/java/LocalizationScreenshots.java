import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocalizationScreenshots {

    @Test
    public void makeScreenshots() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dev-cl.twinwingames.com:85/relax/onewaybook/test/build-107/?moneymode=fun&cheatsOn=true&developerMode=true");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement preLoader = driver.findElement(By.id("preLoader"));
        WebElement start = driver.findElement(By.xpath("//span[contains(text(), 'START')]"));
        /*if (start.isDisplayed()) {
            new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot((WebDriver) preLoader);
        }*/
    }
}
