import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy (id = "login-form-username")
    WebElement loginField;

    @FindBy (id = "login-form-password")
    WebElement passField;

    @FindBy (id = "login-form-submit")
    WebElement loginForm;

    @FindBy (xpath = "//*[@role='alertdialog']")
    WebElement alert;

    public String getAllertText () {
        return alert.getText();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login (String login, String password) {
        sleepFewSeconds();
        loginField.sendKeys(login);
        passField.sendKeys(password);
        submit();
    }

    private void sleepFewSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submit () {
        loginForm.click();
    }

}
