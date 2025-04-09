package ondia.tests.tests;

import utils.CrossBrowserTestBase;
import org.testng.annotations.Test;

public class C16CrossBrowserTest extends CrossBrowserTestBase {

    @Test
    void test01(){
        driver.get("https://google.com");
        assert driver.getTitle().contains("Google");
    }

    @Test
    void test02(){
        driver.get("https://linkedin.com");
        assert driver.getTitle().contains("LinkedIn");
    }

    @Test
    void test03(){
        driver.get("https://clarusway.com");
        assert driver.getTitle().contains("Bootcamp");
    }

}
