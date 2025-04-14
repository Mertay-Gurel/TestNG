package ondia.tests.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class C17ParallelTest {

    @Test
    public void test01() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        assertTrue(driver.getTitle().contains("Google"));
        driver.quit();
    }
    @Test
    public void test02() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
        driver.quit();

    }
    @Test
    public void test03() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://instagram.com");
        assertTrue(driver.getTitle().contains("Instagram"));
        driver.quit();

    }
    @Test
    public void test04() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        assertTrue(driver.getTitle().contains("Facebook"));
        driver.quit();

    }
    @Test
    public void test05() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        assertTrue(driver.getTitle().contains("Amazon"));
        driver.quit();

    }
}
