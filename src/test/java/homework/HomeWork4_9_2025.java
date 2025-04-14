package homework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class HomeWork4_9_2025  {

   //Go to URL: https://opensource-demo.orangehrmlive.com/
   //Login with negative credentilas by Data Provider.
   //Then assert that ''Invalid credentials'’ is displayed.
   protected static WebDriver driver;

    @BeforeClass//Her Class öncesi çalışır.
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Web elementin yüklenip bulunması için 10 saniyeye kadar bekler. NoSuchElementException atar.
    }

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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
