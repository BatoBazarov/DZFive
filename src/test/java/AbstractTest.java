import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
     static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();  //регистрация драйвера
        ChromeOptions options = new ChromeOptions();  //создание объекта ChromeOptions
        options.addArguments("--incognito");          //добавление в этот объект опции (В режиме инкогнито)
        options.addArguments("start-maximized");      //добавлени опции (Запустить браузер на весь экран)
        driver = new ChromeDriver(options);  //запуск самого браузера
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  //установка значение по умолчанию
    }

    @AfterAll
    static void close() {
        driver.quit();
    }
    public static WebDriver getDriver() {

        return driver;
    }
}



