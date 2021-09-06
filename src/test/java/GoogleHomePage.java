import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage {

    SelenideElement searchFields = $(".gLFyf");

    public SelenideElement getSearchFields() {
        return searchFields;
    }
}
