package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DriverThreadLocal_CrossParalell;

import java.util.List;

public class Cross02 extends DriverThreadLocal_CrossParalell {

    WebDriver driver;

    @Test
    @Parameters("browser")
    public void test01(@Optional("chrome") String browser) throws InterruptedException {
        driver = DriverThreadLocal_CrossParalell.getDriver(browser);
        driver.get("http://crossbrowsertesting.github.io");
        //Click to To-Do App
        driver.findElement(By.xpath("//*[text()='To-Do App']")).click();
        //Checking Box to do-4 and Checking Box to do-5
        driver.findElement(By.xpath("//input[@name='todo-4']")).click();
        driver.findElement(By.xpath("//input[@name='todo-5']")).click();
        Thread.sleep(2000);
        List<WebElement> liste1 = driver.findElements(By.xpath("//span[@class='done-true']"));
        System.out.println("To do done list size: " + liste1.size());
        // So we'll assert that this is correct.
        Assert.assertEquals(liste1.size(), 2);
        System.out.println("Entering Text");
        WebElement addedTxt = driver.findElement(By.xpath("//input[@id='todotext']"));
        addedTxt.sendKeys("we added is Run Selenium Test" + Keys.ENTER);
        Assert.assertTrue(addedTxt.isDisplayed());
        System.out.println("Archiving old todos");
        driver.findElement(By.xpath("//*[text()='archive']")).click();
        //    driver.findElement(By.linkText("archive")).click();
        List<WebElement> liste2=driver.findElements(By.xpath("//span[@class='done-false']"));
        System.out.println("To does not done size = " + liste2.size());
        Assert.assertEquals(liste2.size(),4);
        System.out.println("Test Finished");
        DriverThreadLocal_CrossParalell.quitDriver();
    }

    @Test
    @Parameters("browser")
    public void test02(@Optional("chrome") String browser) {
        driver = DriverThreadLocal_CrossParalell.getDriver(browser);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("incorrectPassword");
        driver.findElement(By.cssSelector("button#submit")).click();
        SoftAssert softAssert = new SoftAssert();
        String expectedErrorMes = "Your password is invalid!";
        WebElement actualErrorMes = driver.findElement(By.cssSelector("div[id='error']"));
        softAssert.assertTrue(actualErrorMes.isDisplayed());
        softAssert.assertEquals(actualErrorMes.getText(), expectedErrorMes);
        softAssert.assertAll();
        DriverThreadLocal_CrossParalell.quitDriver();
    }
}