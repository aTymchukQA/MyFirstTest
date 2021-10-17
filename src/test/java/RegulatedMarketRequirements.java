import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RegulatedMarketRequirements {

    @Test
    public void gameRulesText() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("http://dev-cl.twinwingames.com:85/relax/onewaybook/test/build-107/?moneymode=fun&cheatsOn=true&developerMode=true");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement start = driver.findElement(By.xpath("//span[contains(text(), 'START')]"));
        start.click();
        //js.executeScript("arguments[0].click();", start);
        WebElement settings = driver.findElement(By.className("sprite"));
        settings.click();
        //js.executeScript("arguments[0].click();", settings);
        WebElement gameRules = driver.findElement(By.className("fa-question-circle-o"));
        gameRules.click();
        //js.executeScript("arguments[0].click();", gameRules);
        WebElement rule = driver.findElement(By.xpath("//div[@class='rules']/ul/li[1]"));
        Assert.assertEquals(rule.getText(), "The wild symbol substitutes all symbols except the scatter symbol.", "Needed regulated market message is absent");
    }

    @Test
    public void autoplayFalse() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dev-cl.twinwingames.com:85/relax/onewaybook/test/build-107/?moneymode=fun&cheatsOn=true&developerMode=true");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement start = driver.findElement(By.xpath("//span[contains(text(), 'START')]"));
        start.click();
        WebElement autoplay = driver.findElement(By.className("autoplay"));
        Assert.assertFalse(autoplay.isDisplayed(), "Autoplay is active");
    }

    @Test
    public void skipPossibility() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dev-cl.twinwingames.com:85/relax/onewaybook/test/build-107/?moneymode=fun&cheatsOn=true&developerMode=true");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement start = driver.findElement(By.xpath("//span[contains(text(), 'START')]"));
        start.click();
        WebElement spin = driver.findElement(By.className("spin-button"));
        spin.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement stop = driver.findElement(By.className("skip-button"));
        Assert.assertFalse(stop.isEnabled(), "Skip is possible");
    }

    @Test
    public void maxBet() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dev-cl.twinwingames.com:85/relax/onewaybook/test/build-107/?moneymode=fun&cheatsOn=true&developerMode=true");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement start = driver.findElement(By.xpath("//span[contains(text(), 'START')]"));
        start.click();
        WebElement stakeValue = driver.findElement(By.xpath("//div[@class='infoArea bet ']/span"));
        WebElement increaseStake = driver.findElement(By.className("increase"));
        String expectedMaxStake = "1000.00";
        while (increaseStake.isEnabled()) {
            increaseStake.click();
            driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        }
        String actualMaxStake = stakeValue.getText();
        Assert.assertEquals(actualMaxStake, expectedMaxStake, "Wrong max stake");
    }

   /* @Test
    public void spinDuration() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dev-cl.twinwingames.com:85/relax/onewaybook/test/build-107/?moneymode=fun&cheatsOn=true&developerMode=true");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement start = driver.findElement(By.xpath("//span[contains(text(), 'START')]"));
        start.click();

    } */
}
