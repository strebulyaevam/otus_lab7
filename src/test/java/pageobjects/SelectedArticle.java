package pageobjects;

import driverconfig.DriverServies;
import helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectedArticle {

    private static Logger Log = LogManager.getLogger(SelectedArticle.class);

    WebDriver driver;
    WebDriverWait waiter;
    DriverServies driverServies;

    public SelectedArticle(DriverServies driverServies) {
        this.driverServies = driverServies;
        this.driver = driverServies.getDriver();
        waiter = new WebDriverWait(driver, 4);
        TestHelper.isPageLoad(waiter, loc_post_caption, "The Best articles for the week");
    }

    By loc_post_caption = By.cssSelector("span.post__title-text");

    public String getPageCaption(){
        return TestHelper.getTextFromElem(driver, waiter, loc_post_caption, "post__title-text");
    }


}
