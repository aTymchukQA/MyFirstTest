import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {

    GoogleHomePage googleHomePage = new GoogleHomePage();

    @Test
    public void newTest() {
        //Configuration.browser = "firefox";
        Configuration.headless = true;
        Configuration.timeout = 1000;
        open("https://google.com");
        String actualTitle = Selenide.title();
        String expectedTitle = "Google";
        googleHomePage.getSearchFields().should(appear).setValue("test").pressEnter();
        $(By.className("gNO89b")).should(Condition.visible).click();
        $(By.tagName("h3")).shouldHave(text("Speedtest"));
        //Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
    }
}
