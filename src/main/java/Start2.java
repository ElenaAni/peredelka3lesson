
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Start2 {


    /*
        Начало работы со стендом, экран логина.

        2. Переключение между вкладками браузера
        3. Завершение работы драйвера (QUIT/CLOSE)

     */
    public static class Start_2 {

        private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

        public static <WebDriver, JavascriptExecutor, ChromeOptions> void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            //Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
            ChromeOptions options = new ChromeOptions();

            //Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            WebDriver driver = new ChromeDriver(options);

            // Открываем первую вкладку
            driver.get(LOGIN_PAGE_URL);
            Thread.sleep(1000);

            // Создаем вторую вкладку. (Разбор на уроке 5, сейчас показать как магию)
            ((JavascriptExecutor) driver).executeScript("window.open()");

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            // Переключаемся на вторую вкладку
            driver.switchTo().window(tabs.get(1));
            driver.get("https://ya.ru");
            Thread.sleep(3000);

            ((JavascriptExecutor) driver).executeScript("alert('Hello!!')");

            Thread.sleep(3000);

            String alertText = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            System.out.println("alertText: " + alertText);

            // Возвращаемся на первую вкладку
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(2000);

            // Демонстрация CLOSE - закрывает вкладку
            driver.close();
            Thread.sleep(1000);

            // Демонстрация QUIT - закрывает браузер
            driver.quit();
        }

    }
}
