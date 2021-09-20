import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {

    GoogleHomePage googleHomePage = new GoogleHomePage();

    @Test
    public void newTest() {
        //browser = "firefox";
        Configuration.headless = true;
        //Configuration.timeout = 1000;
        Configuration.browser = System.getProperty("browser");
        Configuration.baseUrl = "https://google.com";
        open("/google.com");
        System.out.println(browser+" current browser");
        String actualTitle = Selenide.title();
        String expectedTitle = "Google";
        googleHomePage.getSearchFields().should(appear).setValue("test").pressEnter();
        $(By.tagName("h3")).shouldHave(text("Speedtest"));
        //Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
    }

    @Test
    public void headerTest() {
        Configuration.browser = "chrome";
        open("http://automationpractice.com/index.php");
        AutomationPracticeHeader header = new AutomationPracticeHeader();
        header.contactUs.click();
        Selenide.title().equals("Contact Us - My store");
    }
}
