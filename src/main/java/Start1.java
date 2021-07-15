import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Start1 {
    /*
        Начало работы со стендом, экран логина.

        1. Настройка драйвера

        Примечание: запуская несколько раз, продемонстрировать проблему незакрывающихся браузеров в System Dock
     */
    public static class Start_1 {

        public static WebDriver driver;
        private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
        private static Object WebDriverManager;


        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriverManager.chromedriver().setup();

            //Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
            ChromeOptions options = new ChromeOptions();


            driver = new ChromeDriver(options);
            driver.get(LOGIN_PAGE_URL);
            Thread.sleep(1000);

            // Демонстрация разворачивания окна браузера
            driver.manage().window().maximize();
            Thread.sleep(1000);
            // Демонстрация установки конкретных размеров окна
            driver.manage().window().setSize(new Dimension(500, 500));
            Thread.sleep(1000);
        }

    }

}
