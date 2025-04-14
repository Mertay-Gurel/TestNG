package homework.mentoring;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LogClassTest {

    private static final Logger logger = LoggerFactory.getLogger(LogClassTest.class);

    @Test
    public void testLog() {
        logger.info("Testim Başlıyor");

        int a = 1;
        int b = 2;
        logger.debug("İşlem kontrol ediliyor : " + a + b);
        logger.info("sonuç yazdırılıyor");




    }
}
