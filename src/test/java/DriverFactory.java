import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public void getDriver() {
        WebDriver driver;

        String browserName = System.getProperty("browser");

        if (browserName.equals("Chrome")) {
            //driver = new ChromeDriver();
            Configuration.browser = browserName;
        }
        else if (browserName.equals("Firefox")) {
            Configuration.browser = browserName;
        }
        else driver = new ChromeDriver();

    }

}
