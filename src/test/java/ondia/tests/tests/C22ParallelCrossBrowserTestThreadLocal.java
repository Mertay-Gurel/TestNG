package ondia.tests.tests;

import utils.CrossBrowserParellelTestBase;
import org.testng.annotations.Test;

public class C22ParallelCrossBrowserTestThreadLocal extends CrossBrowserParellelTestBase {
    @Test
    void test01(){

        getDriver().get("https://google.com");
        assert getDriver().getTitle().contains("Google");
        getDriver().quit();
    }

    @Test
    void test02(){
        getDriver().get("https://linkedin.com");
        assert getDriver().getTitle().contains("LinkedIn");
        getDriver().quit();
    }

    @Test
    void test03(){
        getDriver().get("https://clarusway.com");
        assert getDriver().getTitle().contains("Bootcamp");
        getDriver().quit();
    }

}
