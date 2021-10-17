import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LocalizationScreenshots {

    @Test
    public void makeScreenshots() throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dev-cl.twinwingames.com:85/relax/onewaybook/test/build-107/?moneymode=fun&cheatsOn=true&developerMode=true");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement start = driver.findElement(By.xpath("//span[contains(text(), 'START')]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source_file, new File("D:\\localizationAutomated\\loadingScreen.png"));
        start.click();
        WebElement spin = driver.findElement(By.className("spin-button"));
        if (spin.isDisplayed()) {File source_file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source_file2, new File("D:\\localizationAutomated\\mainGame.png"));}
        WebElement settings = driver.findElement(By.className("sprite"));
        settings.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        File source_file3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source_file3, new File("D:\\localizationAutomated\\paytable.png"));
    }
}
