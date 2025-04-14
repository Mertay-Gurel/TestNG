package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class DriverThreadLocal_CrossParalell {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected final Logger logger = LogManager.getLogger(this.getClass());


    @Parameters("browser")
    public static WebDriver getDriver(@Optional("chrome")String browser) {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = createDriver(browser);
            driverThreadLocal.set(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driverThreadLocal.get();
    }


    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            case "safari":
                return new SafariDriver();

            default:
                throw new IllegalArgumentException("Geçersiz tarayıcı türü: " + browser);
        }

    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }


}