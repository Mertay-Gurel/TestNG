package ondia.tests.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DataProviderUtils;
import utils.TestBase;

import java.time.Duration;

public class C14DataProviderSampleTest03 extends TestBase {
    @Test(dataProvider = "benimDatam",dataProviderClass = DataProviderUtils.class)
    public void negativeLoginTestWithDataProvider(String name,String password, String errMessage){
//Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login");

//Type username student into Username field
        driver.findElement(By.id("username")).sendKeys(name);

//Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys(password);

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
        softAssert.assertTrue(errorText.contains(errMessage));

        //3. Adım:
        softAssert.assertAll();
    }

}
