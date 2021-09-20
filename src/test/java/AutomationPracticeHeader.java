import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class AutomationPracticeHeader {

    SelenideElement contactUs = $(By.id("contact-link"));
    SelenideElement signIn = $(By.className("header_user_info"));
    SelenideElement shopPhone = $(By.className("shop-phone"));
}
