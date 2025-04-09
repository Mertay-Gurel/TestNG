package ondia.tests.tests;

import org.testng.annotations.Test;
import utils.CrossBrowserTestBase;

public class C21ParallelCrossBrowserTest {

    public class C16ParallelCrossBrowserTest extends CrossBrowserTestBase {

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
}
