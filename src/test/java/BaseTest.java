import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.page.MainPage;

public class BaseTest {

    /*
    Переменные окружения, прописанные в системе:
    WEBDRIVER - путь к папке с драйвером для запуска ЯндексБраузера. Для удобства нужный драйвер добавлен в resources
    YANDEX_BROWSER_PATH - путь к исполняемому файлу ЯндексБраузера в системе
     */

    protected WebDriver driver;

    @Before
    public void setUpDriver() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);
        driver.get(MainPage.URL);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.chromedriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case "yandex":
                System.setProperty("webdriver.chrome.driver",
                        System.getenv("WEBDRIVER"));
                ChromeOptions options = new ChromeOptions();
                options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

}
