package ondia.tests.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class C24AllureTest02 {

    @Test()
    public void blockerTest() {
        System.out.println("BLOCKER");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void criticalTest() throws Exception {
        System.out.println("CRITICAL");
        throw new Exception();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void normalTest() {
        System.out.println("NORMAL");
        throw  new SkipException("Skipped");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void minorTest() {
        System.out.println("MINOR");
        assert false;
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void trivialTest() {
        System.out.println("TRIVIAL");
    }


}
