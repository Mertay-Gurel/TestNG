package ondia.tests.tests.smoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class NegativeLoginTest extends TestBase {

    @Test
    public void negativeLoginTest() {

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        String email = "ondia256@hotmail.com";
        String password1 = "12345678";


        By emailBy = By.id("email");
        By password = By.id("password");
        By submit = By.id("submit");
        By errorTextBy = By.id("error");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(password).sendKeys(password1);
        driver.findElement(submit).click();

        WebElement errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(errorTextBy));

        assertTrue(errorText.isDisplayed());


    }
}
