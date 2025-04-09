package ondia.tests.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestBase;

import java.time.Duration;

public class C14DataProviderSampleTest01 extends TestBase {
    @Test
    public void negativeLoginTestWithInvalidName(){
//Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login");

//Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("invalidName");

//Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

//Click Submit button.
        driver.findElement(By.id("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d->
        {
            return d.findElement(By.id("error")).isDisplayed();
        });
        String errorText = driver.findElement(By.id("error")).getText();
        System.out.println("errorText = " + errorText);

        String url = driver.getCurrentUrl();
        //Dost assert adımları:
        //1.Adım:
        SoftAssert softAssert = new SoftAssert();

        //2.Adım:
        softAssert.assertTrue(errorText.contains("Your username is invalid!"));

        //3. Adım:
        softAssert.assertAll();
    }
    @Test
    public void negativeLoginTestWithInvalidPassword(){
//Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login");

//Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("student");

//Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("InvalidPass");

//Click Submit button.
        driver.findElement(By.id("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d->
        {
            return d.findElement(By.id("error")).isDisplayed();
        });
        String errorText = driver.findElement(By.id("error")).getText();
        System.out.println("errorText = " + errorText);
//Verify new page URL contains practicetestautomation.com/logged-in-successfully/

        String url = driver.getCurrentUrl();
        //Dost assert adımları:
        //1.Adım:
        SoftAssert softAssert = new SoftAssert();

        //2.Adım:
        softAssert.assertTrue(errorText.contains("Your password is invalid!"));

        //3. Adım:
        softAssert.assertAll();
    }
    @Test
    public void negativeLoginTestWithInvalidNameAndInvalidPassWord(){
//Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login");

//Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("invalidName");

//Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("invPassword");

//Click Submit button.
        driver.findElement(By.id("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d->
        {
            return d.findElement(By.id("error")).isDisplayed();
        });
        String errorText = driver.findElement(By.id("error")).getText();
        System.out.println("errorText = " + errorText);
//Verify new page URL contains practicetestautomation.com/logged-in-successfully/

        String url = driver.getCurrentUrl();
        //Dost assert adımları:
        //1.Adım:
        SoftAssert softAssert = new SoftAssert();

        //2.Adım:
        softAssert.assertTrue(errorText.contains("Your username is invalid!"));

        //3. Adım:
        softAssert.assertAll();
    }
}
