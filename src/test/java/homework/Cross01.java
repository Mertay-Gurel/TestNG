package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DriverThreadLocal_CrossParalell;

public class Cross01 extends DriverThreadLocal_CrossParalell {

    // "https://automationexercise.com/" sitesine git
    // sign up / login e tıkla
    // name ve email ile giriş yap
    // Formda "Street address" alanının zorunlu olduğunu verify et

    WebDriver driver;

    @Test
    @Parameters("browser")
    public void test(@Optional("chrome") String browser) throws InterruptedException {
        driver = DriverThreadLocal_CrossParalell.getDriver(browser);
        driver.get("https://automationexercise.com/");
        WebElement signUp = driver.findElement(By.linkText("Signup / Login"));
        signUp.click();
        Actions action = new Actions(driver);
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        action.
                click(nameBox).
                sendKeys("hale").
                sendKeys(Keys.TAB).
                sendKeys("halelk@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        WebElement title = driver.findElement(By.xpath("//input[@value='Mrs']"));
        title.click();
        WebElement nameArea = driver.findElement(By.xpath("//input[@id='name']"));
        action.click(nameArea).
                sendKeys(Keys.TAB).sendKeys("12345").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("hale").
                sendKeys(Keys.ENTER).
                sendKeys("kaya").
                sendKeys(Keys.ENTER).
                sendKeys("kaya").
                perform();
        Thread.sleep(2000);
        DriverThreadLocal_CrossParalell.quitDriver();
    }
}