package utils;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtils  implements ITestListener, IRetryAnalyzer , IAnnotationTransformer {

    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " testi başladı.");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " testi başarılı bir şekilde bitirildi.");
        ExtentReportUtils.createTestReport(result.getName(), result.getName() + " testi başarılı bir şekilde geçti.");
        ExtentReportUtils.passAndCaptureScreenshot(result.getName());
        ExtentReportUtils.pass("Başarılı");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " testi kaldı!!!");
        ExtentReportUtils.createTestReport(result.getName(), result.getName() + " testi fail oldu!!!");
        ExtentReportUtils.failAndCaptureScreenshot(result.getName());
        ExtentReportUtils.fail("Kaldı");

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " testi atlandı!!!");
    }

    public void onStart(ITestContext context) {
        System.out.println("Test Başladı: " + context.getStartDate());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test Bitti: " + context.getEndDate());
        ExtentReportUtils.flush();
    }

    // Otomatik olarak Başarısız Test Senaryolarını bir kez daha yeniden çalıştırır
// IRetryAnalyzer Yöntemi Uygulanmıştır
// BU yöntem, BAŞARISIZ TEST SENARYOLARINI YENİDEN ÇALIŞTIRMAK İÇİN OTOMATİK OLARAK ÇAĞRILACAKTIR
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // YENİDEN ÇALIŞTIRMA SAYISI

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    // IAnnotationTransformer yöntemi eklenmiştir
// Bu, başarısız test senaryolarını otomatik olarak testng xml dosyalarını kullanarak yeniden çalıştırır
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersUtils.class);
    }


}