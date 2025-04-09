package ondia.tests.tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C11ParametrizedTest {

    @Test
    @Parameters({"firstname","password"})
    public void parametrizedTest(@Optional("isimsiz") String isim, @Optional("geçersiz") String sifre) {
        System.out.println("isim = " + isim);
        System.out.println("sifre = " + sifre);
    }

    @Test
    @Parameters({"comment"})
    public void parametrizedTest02(@Optional("yorum yok !.") String yorum ) {
        System.out.println("isim = " + yorum);

    }

    @Test
    @Parameters({"firstname","password","comment"})
    public void parametrizedTest03(@Optional("isimsiz") String isim, @Optional("geçersiz") String sifre,@Optional("Yorum yok") String comment) {
        System.out.println("isim = " + isim);
        System.out.println("sifre = " + sifre);
        System.out.println("comment = " + comment);
    }

    @Test
    @Parameters({"firstname","age","isMarried"})
    public void parametrizedTest04(@Optional("isimsiz") String isim, @Optional("18") int yas,@Optional("false") boolean evliMi) {
        System.out.println("isim = " + isim);
        System.out.println("yas = " + yas);
        System.out.println("evliMi = " + evliMi);
    }
}
