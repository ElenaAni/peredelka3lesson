
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

public static <WebDriver> void main(String[] args) {
    String s = System.setProperty(
            "webdriver.chrome.driver", "src/main/resources/chromedriver"
    );
    WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }

}
