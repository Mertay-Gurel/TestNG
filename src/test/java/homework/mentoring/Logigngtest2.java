package homework.mentoring;

import org.testng.annotations.Test;
import utils.DriverThreadLocal_CrossParalell;

public class Logigngtest2 extends DriverThreadLocal_CrossParalell {

    @Test
    public void classLogger()  {

        logger.info("Login testi başladı");
        String username = "user1";
        String password = "1234";

        logger.debug("Kullanıcı adı: " + username);
        logger.debug("Şifre: " + password);

        boolean result = username.equals("user1") && password.equals("1234");

        if (result) {
            logger.info("Login başarılı!");
        } else {
            logger.error("Login başarısız!");
        }

        assert result;

    }
}
