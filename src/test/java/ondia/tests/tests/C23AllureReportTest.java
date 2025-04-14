package ondia.tests.tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C23AllureReportTest {
    @Test(description = "Google ana sayfasını test et")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Ana Sayfa Fonksiyonu")
    @Feature("Google Testleri")
    @Owner("Suleyman")
    public void allureTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        assert driver.getTitle().contains("Google");
        driver.quit();
    }
    @Test(description = "Google ana sayfasını test et")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Arama fonksiyonu")
    @Feature("Google Testleri")
    @Owner("Suleyman")
    public void allureTest02(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Güneş Gözlüğü");
        assert driver.findElement(By.name("q")).isDisplayed();
        driver.quit();
    }
    @Test(description = "LinkedIn ana sayfasını test et")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Fonksiyonu")
    @Feature("LinkedIn Testleri")
    @Owner("Suleyman")
    public void allureTest03(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://linkedin.com");
        assert driver.getTitle().contains("LinkedIn");
    }
}
