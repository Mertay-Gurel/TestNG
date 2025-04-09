package ondia.tests.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestBase;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class C09HardAndSoftAssert extends utils.TestBase {
/*
    Test Case1: Positive Login Test
    Open page https://practicetestautomation.com/practice-test-login/
    Type username student into Username field
    Type password Password123 into Password field
    Click Submit button.
    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
    Verify button Log out is displayed on the new page.
*/


    @Test
    public void hardAssertionTest() {
        String name = "student";
        String password = "Password123";
        String urlContains = "https://practicetestautomation.com/logged-in-successfully/";
        String expectedText1 = "Congratulations";
        String expectedText2 = "successfully logged in";

        By nameBy = By.id("username");
        By passwordBy = By.id("password");
        By submitButtonBy = By.id("submit");
        By logOutButtonBy = By.xpath("//a[text()='Log out']");
        By expectedTitleTextBy = By.xpath("//h1[contains(text(),'Logged In')] | //strong[contains(text(),'successfully logged in')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

   //     Test Case1: Positive Login Test
   //     Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

   //     Type username student into Username field
        driver.findElement(nameBy).sendKeys(name);

   //     Type password Password123 into Password field
        driver.findElement(passwordBy).sendKeys(password);

   //     Click Submit button.
        driver.findElement(submitButtonBy).click();

   //     Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        assertTrue(driver.getCurrentUrl().contains(urlContains),"Url beklenen texti içermiyor");

   //     Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        assertTrue(driver.findElement(expectedTitleTextBy).isDisplayed());

   //     Verify button Log out is displayed on the new page.
        assertTrue(driver.findElement(logOutButtonBy).isDisplayed());
    }

    @Test
    public void softAssertionTest() {
        String name = "student";
        String password = "Password123";
        String urlContains = "https://practicetestautomation.com/logged-in-successfully/";
        String expectedText1 = "Congratulations";
        String expectedText2 = "successfully logged in";

        By nameBy = By.id("username");
        By passwordBy = By.id("password");
        By submitButtonBy = By.id("submit");
        By logOutButtonBy = By.xpath("//a[text()='Log out']");
        By expectedTitleTextBy = By.xpath("//h1[contains(text(),'Logged In')] | //strong[contains(text(),'successfully logged in')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //     Test Case1: Positive Login Test
        //     Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //     Type username student into Username field
        driver.findElement(nameBy).sendKeys(name);

        //     Type password Password123 into Password field
        driver.findElement(passwordBy).sendKeys(password);

        //     Click Submit button.
        driver.findElement(submitButtonBy).click();

        SoftAssert softAssert = new SoftAssert();

        //     Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        softAssert.assertTrue(driver.getCurrentUrl().contains(urlContains),"Url beklenen texti içermiyor");

        //     Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        softAssert.assertTrue(driver.findElement(expectedTitleTextBy).isDisplayed());

        //     Verify button Log out is displayed on the new page.
        softAssert.assertTrue(driver.findElement(logOutButtonBy).isDisplayed());

        softAssert.assertAll();
    }
}
