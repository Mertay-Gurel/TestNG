package ondia.tests.tests;

import org.testng.annotations.Test;

public class C18ParallelTestThreads {
    @Test
    public void test01() {
        System.out.println("Test 01");
        System.out.println("Thread ID : " + Thread.currentThread().threadId());

    }
    @Test
    public void test02() {
        System.out.println("Test 02");
        System.out.println("Thread ID : " + Thread.currentThread().threadId());

    }
    @Test
    public void test03() {
        System.out.println("Test 03");
        System.out.println("Thread ID : " + Thread.currentThread().threadId());

    }
    @Test
    public void test04() {
        System.out.println("Test 04");
        System.out.println("Thread ID : " + Thread.currentThread().threadId());

    }
    @Test
    public void test05() {
        System.out.println("Test 05");
        System.out.println("Thread ID : " + Thread.currentThread().threadId());
    }
    @Test
    public void test06() {
        System.out.println("Test 06");
        System.out.println("Thread ID : " + Thread.currentThread().threadId());
    }
    @Test
    public void test07() {
        System.out.println("Test 07");
        System.out.println("Thread ID : " + Thread.currentThread().threadId());
    }
}
