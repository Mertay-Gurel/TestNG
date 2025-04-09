package ondia.tests.tests.smoketest;

import utils.DataProviderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class C20DataProviderParallelTest {
    @Test(dataProvider = "namePassCommProviderParallel",dataProviderClass = DataProviderUtils.class )
    public void dataProviderFakerTest(String username, String password, String comment) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Enter username
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(500);

//Enter password
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(500);

//Enter comment
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys(comment);
        Thread.sleep(500);

//Click submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//Verify username
        String usernameText = driver.findElement(By.id("_valueusername")).getText();
        assertEquals(username, usernameText);

        driver.quit();
    }

}
