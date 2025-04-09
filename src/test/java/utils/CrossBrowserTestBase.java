package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class CrossBrowserTestBase {//Classı abstract yaparak bu classtan obje oluşturulmasını engelliyoruz.

    protected static WebDriver driver;

    @BeforeMethod()//Her Class öncesi çalışır.
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) { // xml ile parametre vermeden çalıştırılırsa default olarak chrome açılacak

        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Web elementin yüklenip bulunması için 10 saniyeye kadar bekler. NoSuchElementException atar.
    }

    @AfterMethod//Her Class sonrası çalışır.
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
