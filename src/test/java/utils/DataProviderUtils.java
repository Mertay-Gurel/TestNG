package utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider(name = "benimDatam")
    public Object[][] userNamePasswordProvider(){
        Object[][] dataArr = {
                {"invalidName","Password123","Your username is invalid!"},
                {"student","invalidPassword","Your password is invalid!"},
                {"invalidName","invalidPassword","Your username is invalid!"}
        };
        return dataArr;
    }

    @DataProvider()
    public Object[][] namePassCommProvider(){
        Faker faker = new Faker();
        Object [][] dataArr = {
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()}
        };
        return dataArr;
    }

    @DataProvider
    public Object[][] namePassCommProviderFromExcelFile(){
        String path = "resources/username_password.xlsx";
        ExcelUtils excelUtils = new ExcelUtils(path,"Sheet1");
        return excelUtils.getDataArrayWithoutFirstRow();
    }
    @DataProvider(parallel = true) // XML kullanmadan çalıştırılırsa her döngü için bir browser açılır.
    public Object[][] namePassCommProviderParallel(){
        Faker faker = new Faker();
        Object [][] dataArr = {
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()},
                {faker.name().username(), faker.internet().password(),faker.lorem().paragraph()}
        };
        return dataArr;
    }
}
