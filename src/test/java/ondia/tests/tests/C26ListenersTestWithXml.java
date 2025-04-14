package ondia.tests.tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class C26ListenersTestWithXml {

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() {
        System.out.println("test02 exception atsın");
        throw new RuntimeException();
    }

    @Test
    public void test03() {
        System.out.println("test03 Atlansın");
        throw new SkipException("Skipped");
    }

    @Test
    public void test04() {
        System.out.println("test04");
    }

    @Test
    public void test05() {
        System.out.println("test05");
        assert false;
    }
}
