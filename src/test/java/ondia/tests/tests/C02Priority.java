package ondia.tests.tests;

import org.testng.annotations.Test;

public class C02Priority {
    /*
        - Test annotationlara öncelik verilmesine yardımcı olurken, varsayılan öncelik 0 ile başlar ve testler artan sırada yürütülür.
        - Test annotationda herhangi bir priority attribute yoksa priority sıfır kabul edilir.
        - TestNG (default) olarak @Test annotationları alfabetik sıraya göre execute eder.
*/

    @Test (priority = 1 )
    public void test01() {
        System.out.println("Test01 çalıştı...");
    }
    @Test (priority = 2)
    public void test02() {
        System.out.println("Test02 çalıştı...");
    }
    @Test
    public void test03() {
        System.out.println("Test03 çalıştı...");
    }
    @Test (priority = -3)
    public void test04() {
        System.out.println("Test04 çalıştı...");
    }
    @Test (priority = -4)
    public void test05() {
        System.out.println("Test05 çalıştı...");
    }
}
