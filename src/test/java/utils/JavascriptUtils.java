package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptUtils extends TestBase {

    // Belirtilen WebElement'i JavaScript kullanarak tıklar.
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", element);
    }

    // JavaScript kullanarak sayfa başlığını alır.
    public static String getTitleByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        String title = jsexecutor.executeScript("return document.title;").toString();
        return title;
    }

    // Sayfayı en alta doğru kaydırır.
    public static void scrollDownByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    // Sayfayı en üste doğru kaydırır.
    public static void scrollAllUpByJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    // Belirtilen WebElement'e JavaScript kullanarak odaklanır, yani görünür hale getirir.
    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    // Belirtilen WebElement'in arkaplan rengini değiştirir ve ardından eski rengine geri döner, bir tür "flash" efekti oluşturur.
    public static void changeBackgroundColorByJS(WebElement element, String color) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Belirtilen WebElement'in arkaplan rengini hızlı bir şekilde değiştirir, bir tür "flash" efekti oluşturur.
    public static void flash(WebElement element, String color) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 5; i++) {
            changeBackgroundColorByJS(element, color);
            changeBackgroundColorByJS(element, bgColor);
        }
    }

    // Belirtilen mesaj ile bir JavaScript uyarısı oluşturur.
    public static void generateAlert(String message) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        javascriptExecutor.executeScript("alert('" + message + "')");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Belirtilen JavaScript komutunu belirtilen WebElement üzerinde çalıştırır.
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);
    }

    // Belirtilen JavaScript komutunu çalıştırır.
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command);
    }

    // Belirtilen WebElement'in değerini JavaScript kullanarak ayarlar.
    public static void setValueByJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    // Belirtilen elementin değerini JavaScript kullanarak alır ve ekrana yazdırır.
    public static void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println(value);
    }

    // Belirtilen WebElement'e belirtilen kenarlık stiliyle bir kenarlık ekler.
    public static void addBorderWithJS(WebElement element, String borderStyle) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='" + borderStyle + "'", element);
    }

    // Belirtilen WebElement'in değerini JavaScript kullanarak alır.
    public static Object getElementValueJS(WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].value", element);
    }
}
