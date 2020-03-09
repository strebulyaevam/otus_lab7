package pageobjects;

import driverconfig.DriverServies;
import helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrPage {
    private static Logger Log = LogManager.getLogger(RegistrPage.class);

    WebDriver driver;
    WebDriverWait waiter;
    DriverServies driverServies;

    public RegistrPage(DriverServies driverServies) {
        this.driverServies = driverServies;
        this.driver = driverServies.getDriver();
        waiter = new WebDriverWait(driver, 4);
        TestHelper.isPageLoad(waiter, loc_email, "LoginPage");
    }

    By loc_email = By.cssSelector("input[type='email']");
}
