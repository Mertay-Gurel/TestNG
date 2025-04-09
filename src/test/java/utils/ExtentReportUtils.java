package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter;
    protected static ExtentTest extentTest;

    /*
     * Statik blok, ExtentReportUtils.somemethod... çağrıldığında çalışır ve önkoşulları gerçekleştirir
     */
    static {
//        RAPOR ADI VE OLUŞTURULACAĞI YER
//        YOL
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "\\test-output\\reports\\testReport_" + currentDate;
//        HTML şablonunu oluşturmak için extent spark reporter kullanarak yolu belirle
        extentSparkReporter = new ExtentSparkReporter(filePath);
//        Extent raporu oluştur
        extentReports = new ExtentReports();

//        ***********ÖZEL SİSTEM BİLGİLERİ EKLEME ***********
        extentReports.setSystemInfo("Uygulama Adı", "Clarusway IT Birimi");
        extentReports.setSystemInfo("Test Ortamı", "Regresyon");
        extentReports.setSystemInfo("Tarayıcı", "Chrome");
        extentReports.setSystemInfo("Ekip Adı", "Kartallar");
        extentReports.setSystemInfo("SQA", "John");
        extentReports.setSystemInfo("Özellik Numarası", "FE1056");
        extentReports.setSystemInfo("Şirket Adı", "Clarusway");

//        ***********BELGE BİLGİSİ************************
        extentSparkReporter.config().setReportName("Benim Regresyon Raporum");
        extentSparkReporter.config().setDocumentTitle("Benim Regresyon Extent Raporları");
//        ***********YAPILAN YAPILANDIRMALAR BİTTİ********************
//        extent raporları ve extent spark reporter'ı birleştirme
        extentReports.attachReporter(extentSparkReporter);
    }
    //

    /*
     * LOG OLARAK BİLİNEN EXTENT TESTİ OLUŞTURUR
     * Başka herhangi bir rapor metodundan önce bunu kullanmalısınız, aksi takdirde bir istisna alırsınız
     */
    public static void createTestReport(String name, String description) {
        extentTest = extentReports.createTest(name, description);
    }

    //    LOGGER METODLARI
//    ExtentReportUtils.pass("message") -> Log'u başarılı olarak işaretler ve mesaj raporda görünür
    public static void pass(String message) {
        extentTest.log(Status.PASS, message);
    }

    //    ExtentReportUtils.info("message") -> Log'u bilgi olarak işaretler ve mesaj raporda görünür
    public static void info(String message) {
        extentTest.log(Status.INFO, message);
    }

    //    ExtentReportUtils.fail("message") -> Log'u başarısız olarak işaretler ve mesaj raporda görünür
    public static void fail(String message) {
        extentTest.log(Status.FAIL, message);
    }

    //    Bu metod log oluşturur VE ekran görüntüsü alır VE bunları html raporuna ekler
    public static void passAndCaptureScreenshot(String message) {
        extentTest
                .log(Status.PASS, message)
                .addScreenCaptureFromPath(takeScreenshot());
    }

    //    Bu metod log oluşturur VE ekran görüntüsü alır VE bunları html raporuna ekler
    public static void failAndCaptureScreenshot(String message) {
        extentTest
                .log(Status.FAIL, message)
                .addScreenCaptureFromPath(takeScreenshot());
    }

    /*
    RAPORU OLUŞTURMAK İÇİN EN SONDA FLUSH KULLANILMALIDIR
    ExtentReportUtils.flush
    */
    public static void flush() {
        extentReports.flush();
    }

    public static String takeScreenshot() {

        // 1. Ekran görüntüsünü yakalamak için getScreenShotAs yöntemine sahip TakeScreenShot sınıfı
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // 2. Resmi kaydetmek için bir yol oluşturun
        String screenshotsDir = System.getProperty("user.dir") + "/test-output/screenshots";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "ScreenShot" + "_" + timestamp + ".png";
        String filePath = screenshotsDir + "/" + fileName;
       // 3. Resmi dosya olarak belirtilen yola kaydedin
        try {
            FileUtils.copyFile(image, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 4. Resim yolunu String olarak dön
        return "../screenshots/" + fileName;

    }
}
