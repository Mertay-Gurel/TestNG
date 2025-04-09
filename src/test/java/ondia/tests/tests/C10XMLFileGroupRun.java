package ondia.tests.tests;

import org.testng.annotations.Test;

public class C10XMLFileGroupRun {


    @Test(groups = "Group A")
    public void test01() {
        System.out.println("Test 01 - A");
    }

    @Test(groups = "Group C")
    public void test02() {
        System.out.println("Test 02 - C");
    }

    @Test(groups = "Group B")
    public void test03() {
        System.out.println("Test 03 - B");
    }

    @Test(groups = "Group A")
    public void test04() {
        System.out.println("Test 04 - A");
    }

    @Test(groups = "Group B")
    public void test05() {
        System.out.println("Test 05 - B");
    }

    @Test(groups = "Group C")
    public void test06() {
        System.out.println("Test 06 - C");
    }

    @Test(groups = "Group A")
    public void test07() {
        System.out.println("Test 07 - A");
    }

    @Test(groups = "Group C")
    public void test08() {
        System.out.println("Test 08 - C");
    }

    @Test(groups = "Group B")
    public void test09() {
        System.out.println("Test 09 - B");
    }

}
