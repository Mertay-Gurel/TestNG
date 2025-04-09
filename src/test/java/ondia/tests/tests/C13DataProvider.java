package ondia.tests.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C13DataProvider {

    @Test(dataProvider = "isimSifreProvider")
    public void parametrizedTest(String isim,String sifre) {
        System.out.println("isim = " + isim);
        System.out.println("sifre = " + sifre);
        System.out.println("---------------------");
    }

    @DataProvider
    public Object[][] isimSifreProvider(){
        Object [][] dataArr = {
                {"Selim","Seli06"},
                {"johnishio","john87"},
                {"carlos.bright","Selam"}
        };
        return dataArr;
    }

}
