package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.*;

public class TestCaseXmlPractice extends TestBase {

    By webTableLocateTr = By.xpath("//tbody[@style='margin:0;padding:0']/tr");
    By yearsLocate = By.xpath("//tbody[@style='margin:0;padding:0']/tr/td[4]/span");
    @Test
    public void testXmlPractice() {
        // https://www.techlistic.com/p/demo-selenium-practice.html
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        // Find the height of the earliest built tower on this page:
        // (Listedeki ilk inşa edilmiş kulenin uzunluğunu yazdırınız)
        // Your code must be dynamic
        List<WebElement> yillar = driver.findElements(yearsLocate);
        Set<Integer> yearSet = new TreeSet<>();
        for (WebElement w : yillar) {
            int year = Integer.parseInt(w.getText());
            yearSet.add(year);
        }
        System.out.println(yearSet);
        int minYear = yearSet.stream().findFirst().get();
        System.out.println(minYear);

        List<WebElement> webTableElements = driver.findElements(webTableLocateTr);

        List<String> builtYears = new ArrayList<>();
        for (WebElement w : webTableElements) {
            List<WebElement> cells = w.findElements(By.tagName("td"));

            String builtYear = cells.get(3).getText();
            builtYears.add(builtYear);

            if (builtYear.equals("2004")) {
                String height = cells.get(2).getText();
                System.out.println("2004 yılının bina yüksekliği: " + height);
            }

        }


    }

}















