import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class GameDev {

    WebDriver driver;

    @Test
    public void gameRulesText() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("http://dev.twinwingames.com:85/relax/leprechaun/test/build-180/?ticket=testticket-twg33&cheatsOn=true&developerMode=true");
        //$(By.xpath("//span[contains(text(), 'START')]")).click();
        WebElement start = driver.findElement(By.className("block-with-skip-button"));
        js.executeScript("arguments[0].click();", start);
        //executeJavaScript("arguments[0].click()", start);
        //$(By.className("buttonwrapper sprite")).click();
    }


}
