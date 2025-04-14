package ondia.tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class C28ReRunFailedTestByListeners extends TestBase {

    @Test
    public void positiveLogInTest() {
        String email = "ondia25@gmail.com";
        String password = "invalid123";

        By emailBy = By.id("email");
        By passwordBy = By.id("password");
        By submitButtonBy = By.id("submit");
        By addContactButtonBy = By.id("add-contact");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(emailBy).sendKeys(email);

        driver.findElement(passwordBy).sendKeys(password);

        driver.findElement(submitButtonBy).click();

        WebElement addContactButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addContactButtonBy));
        assertTrue(addContactButton.isDisplayed());
    }
}
