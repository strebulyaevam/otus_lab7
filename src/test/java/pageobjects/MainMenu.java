package pageobjects;

import driverconfig.DriverServies;
import helpers.PageSelector;
import helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMenu {
    private static Logger Log = LogManager.getLogger(MainMenu.class);

    WebDriver driver;
    WebDriverWait waiter;
    DriverServies driverServies;

    public MainMenu(DriverServies driverServies) {
        this.driverServies = driverServies;
        this.driver = driverServies.getDriver();
        waiter = new WebDriverWait(driver, 4);
        TestHelper.isPageLoad(waiter, loc_1st_item, "Main Menu");
    }

    By loc_1st_item = By.xpath("//div[@class = 'tabs__level tabs-level_top tabs-menu']//h3[contains(text(), 'Статьи')]");
    By loc_main_menu = By.cssSelector("div.tabs__level.tabs-level_top.tabs-menu h3.tabs-menu__item-text");
    By loc_menu_item_byname(String item_name){ return By.xpath("//div[@class = 'tabs__level tabs-level_top tabs-menu']//h3[ contains(text(), '" + item_name +"')]");}

    public void clickItemByName (String menuname) throws Exception {
        By loc_item = By.xpath("//div[@class = 'tabs__level tabs-level_top tabs-menu']//h3[contains(text(), '" + menuname + "')]");
        Log.info("Try to click on " + menuname + "menu item");
        TestHelper.clickOnElem(waiter, loc_item, "SignIn and Registr btn");
        Log.info("Get menu " + menuname + " successfully");
    }

    public ArticlesPage selectArticleItem() throws Exception {
        clickItemByName("Статьи");
        return new ArticlesPage(driverServies);
     }

    public List<String> getAllMainMenuItems(){
        return TestHelper.getAllMenuItems(driver, loc_main_menu);
    }

    public boolean isMenuItemSelected (String item_name){
        return driver.findElement(loc_menu_item_byname(item_name)).getAttribute("class").contains("tabs-menu__item-text_active");
   }
}
