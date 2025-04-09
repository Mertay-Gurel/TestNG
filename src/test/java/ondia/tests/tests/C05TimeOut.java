package ondia.tests.tests;

import org.testng.annotations.Test;

public class C05TimeOut {
/*
    - Test için bir timeOut - zaman aşımı değeri belirlemeye yardımcı olur (genellikle milisaniye olarak kullanılır). Test belirtilen zaman aşımı değerinden daha fazlasını alırsa, test başarısız olarak işaretlenir.
    - Yöntemin makul bir süre içinde geri döndüğünden emin olmak için bu zaman aşımını bir performans testi yapmak için kullanabiliriz.
*/

    @Test
    public void test01() {
        System.out.println("Test 01");
    }

    @Test(timeOut = 3000)//ThreadTimeoutException --> Testin bitimesi belirlenen süreyi geçerse
    public void test02() throws InterruptedException {
        System.out.println("Test 02");
        Thread.sleep(3100);
    }

    @Test(timeOut = 3000)
    public void test03() throws InterruptedException {
        System.out.println("Test 03");
        Thread.sleep(2900);//Test 3 saniye dolmadan biteceği için test geçer.
    }

}
