package ondia.tests.tests;

import org.testng.annotations.Test;

public class C06Description {
//Testle ilgili bilgileri açıklayan @Test annotationa eklenen ve genelde tek bir dizeden oluşan açıklamadır.

    @Test(description = "This is test 1")
    public void test01() {
        System.out.println("Test 01");
    }

    @Test(description = "This is test 2")
    public void test02() {
        System.out.println("Test 02");
    }

    @Test(description = "This is test 3", dependsOnMethods = "test02", enabled = true, timeOut = 300)
    public void test03() {
        System.out.println("Test 03");
    }
}
