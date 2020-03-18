package lab7.pageobjects;

import lab7.helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class RegistrPage {
    private static Logger Log = LogManager.getLogger(RegistrPage.class);

    @Autowired
    WebDriver driver;

    WebDriverWait waiter;

    public RegistrPage() {
    }

    By loc_email = By.cssSelector("input[type='email']");

    @PostConstruct
    private void init() {
        waiter = new WebDriverWait(driver, 4);
    }

    public void waitUntilLoad (){
        TestHelper.isPageLoad(waiter, loc_email, "LoginPage");
    }


}
