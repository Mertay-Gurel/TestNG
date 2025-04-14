package ondia.tests.tests.smoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.ExtentReportUtils;
import utils.TestBase;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class NegativeLoginTest extends TestBase {

    @Test
    public void negativeLoginTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String email = "ondia256@hotmail.com";
        String password1 = "12345678";
        By emailBy = By.id("email");
        By password = By.id("password");
        By submit = By.id("submit");
        By errorTextBy = By.id("error");

        ExtentReportUtils.createTestReport("negativeLoginTest","Geçersiz credentials");
        ExtentReportUtils.info("Thinking Tester Sayfası açılıyor");
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        if (driver.getTitle().contains("herokuapp")){
            ExtentReportUtils.pass("Thinking Tester Sayfası açıldı");
        }else {
            ExtentReportUtils.fail("Thinking Tester Sayfası açılmadı");
        }

        driver.findElement(emailBy).sendKeys(email);
        ExtentReportUtils.passAndCaptureScreenshot("Email Alanına " + email + "değeri girildi");
        driver.findElement(password).sendKeys(password1);
        ExtentReportUtils.passAndCaptureScreenshot("Password Alanına " + password1 + "değeri girildi");
        driver.findElement(submit).click();
        ExtentReportUtils.pass("Submit buttonuna tıklandı");

        WebElement errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(errorTextBy));
        assertTrue(errorText.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("Hata mesajı ekranda oluştu : " + errorText.getText());
        ExtentReportUtils.flush();

    }
}
