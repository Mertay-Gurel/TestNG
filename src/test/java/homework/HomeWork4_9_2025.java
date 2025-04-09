package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestBase;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class HomeWork4_9_2025 extends TestBase {

   //Go to URL: https://opensource-demo.orangehrmlive.com/
   //Login with negative credentilas by Data Provider.
   //Then assert that ''Invalid credentials'’ is displayed.


    String username = "admin1";
    String Password = "Password";
    By usernameLocate = By.xpath("//input[@placeholder='Username']");
    By PasswordLocate = By.xpath("//input[@placeholder='Password']");
    By login =By.xpath("//button[@type='submit']");
    By errorMesage = By.xpath("//p[normalize-space()='Invalid credentials']");

    @Test(dataProvider = "setNameAndPassword")
    public void testHomeWork(String username,String Password) {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(usernameLocate).sendKeys(username);
        driver.findElement(PasswordLocate).sendKeys(Password);
        driver.findElement(login).click();

        assertTrue(driver.findElement(errorMesage).isDisplayed());

      if (driver.switchTo().alert().getText().contains("Google")) {
          driver.switchTo().alert().accept();
      }else {
          driver.get("https://opensource-demo.orangehrmlive.com/");
      }

    }


    @DataProvider
    public Object[][] setNameAndPassword(){
        Object[][] dataArr = {
                {"name", "password"},
                {"name1","password2"},
                {"name2","password3"}
        };
        return dataArr;
    }

}
