package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class CrossBrowserParellelTestBase {
    // Her thread için ayrı WebDriver nesnesi tutulur
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        WebDriver localDriver;

        switch (browser.toLowerCase()) {
            case "firefox":
                localDriver = new FirefoxDriver();
                break;
            case "edge":
                localDriver = new EdgeDriver();
                break;
            case "chrome":
            default:
                localDriver = new ChromeDriver();
                break;
        }

        driver.set(localDriver); // ThreadLocal'a atıyoruz
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // ThreadLocal temizlenmeli yoksa memory leak olabilir
        }
    }
}
