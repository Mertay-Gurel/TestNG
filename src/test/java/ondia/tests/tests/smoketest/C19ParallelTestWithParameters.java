package ondia.tests.tests.smoketest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class C19ParallelTestWithParameters {

    @Test(threadPoolSize = 3, invocationCount = 8)
    public void paralleltTestWitAnotations() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        assertTrue(driver.getTitle().contains("Google"));
        driver.quit();
    }

}
