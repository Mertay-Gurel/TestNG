package ondia.tests.tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;


public class C08Assertions {

    //Not: Hard Assert daha çok tercih edilir. Çünkü fail durumunda hemen müdehale etmek gerekir.

    //Hard Assertion -> Ilk fail olan assertion'da çalışma durur
    @Test
    void hardAssertionTest(){
        assertTrue(2+4==6,"Toplama işlemi yanlış "); //Burada oluşacak bir fail diğer assertionların çalışmayacağı anlamına gelir.
        assertEquals(5,2+3,"Değerler birbirine eşit değil");
        assertFalse(2==3,"Değerler eşit");

    }

    //Soft Assertion -> Fail durumunda çalışma durmaz son kısımdaki assertAll() methoduna kadar çalışır.
    @Test
    void softAssertionTest(){
        //Soft assertion adımları:
        //1. Adım: SoftAssert objesi oluştur:
        SoftAssert softAssert = new SoftAssert();

        //2. Adım: Assert yap:
        softAssert.assertTrue(2+4==7,"Toplama işlemi yanlış ");
        softAssert.assertEquals(5,2+4,"Değerler birbirine eşit değil");
        softAssert.assertFalse(2==2,"Değerler eşit");

        //3. Adım: assertAll() methodunu kullan
        softAssert.assertAll(); // Bu adım unutulursa assertionlar fail olsa bile test geçer...
        System.out.println("Bu print fail varsa çalışmaz. Çünkü execution asserAll() methodunda durur.");

    }

}
