import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Start3 {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "user";
    private static final String STUDENT_PASSWORD = "1234";

    public static void main(String[] args) throws InterruptedException {
         System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(LOGIN_PAGE_URL);

        // используем имя тега
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        //WebElement loginTextInput2 = driver.findElement(By.id("prependedInput"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        Thread.sleep(2000);

        // используем имя класса
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        Thread.sleep(2000);

        // используя xpath
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();
    }
}

}
