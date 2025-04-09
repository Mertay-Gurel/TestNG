package ondia.tests.tests;

import org.testng.annotations.Test;

public class C03DependsOn {
    /*
- İkinci test methodu birinci test methoduna bağımlı olmak istediğinde bu attribute kullanılır.
- Birinci test methodu başarısız olursa, birinci test methodundaki bağımlı method, yani ikinci test methodu çalışmayacaktır.
- Bir parametrede bir method veya birden çok method iletilebilir.
*/

    @Test
    void login() throws Exception {
        System.out.println("Login Test");
      //  throw new Exception();//Bu methodu bağlı methodlar bu exception sebebi ile çalışmayacaklar.
    }

    @Test(dependsOnMethods = "login")//homePage testi login testine bağlıdır. Login çalışmadan homepage çalışmaz.
    void homePage(){
        System.out.println("Homepage Test");
    }

    @Test (dependsOnMethods = {"homePage","login"})
    void smokeTest(){
        System.out.println("Smoke Test");
    }

    @Test
    void independentTest(){
        System.out.println("independentTest");
    }

}
