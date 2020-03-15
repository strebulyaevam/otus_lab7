package lab7.pageobjects;

import lab7.helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPage {

    private static Logger Log = LogManager.getLogger(LoginPage.class);

    @Autowired
    WebDriver driver;

    WebDriverWait waiter;


    public LoginPage() {
        waiter = new WebDriverWait(driver, 4);
        TestHelper.isPageLoad(waiter, loc_email, "LoginPage");
    }

    By loc_email = By.cssSelector("input[type='email']");
}
