package homework;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestBase;

import static org.apache.commons.compress.harmony.pack200.PackingUtils.log;

public class TestCase02 extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TestCase02.class);
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By error = By.id("error");

    @Test
    public void test01() {
        log("Test Case2: Negative Username Test Starting...");
        log("Open page https://practicetestautomation.com/practice-test-login/");
        driver.get("https://practicetestautomation.com/practice-test-login/");

        log("Type username incorrectUser into Username field.");
        driver.findElement(username).sendKeys("students");

        log("Type password Password123 into Password field.");
        driver.findElement(password).sendKeys("Password123");

        log("Puch Submit button.");
        driver.findElement(submit).click();

        log("Verify error message is displayed.");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.findElement(error).isDisplayed(),"Hata mesajı görünür mü?");

        log("Verify error message text is Your username is invalid!");
        softAssert.assertEquals(driver.findElement(error).getText(), "Your username is invalid!","Hata mesajı text olarak doğru yazıyor mu?");

        softAssert.assertAll();
    }
}
