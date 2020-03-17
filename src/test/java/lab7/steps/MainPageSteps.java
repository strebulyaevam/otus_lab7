package lab7.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab7.TestConfig;
import lab7.pageobjects.MainMenu;
import lab7.pageobjects.TopMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;

import java.util.List;

public class MainPageSteps {

    @Autowired
    MainMenu mainMenu;

    @Autowired
    TopMenu topMenu;

/*
    @Given("Browser \"([^\"]*)\"$\" is open")
    public void openBrowser(String browser) {
        mainPage.openTopic(index - 1);
    }
*/

    @When("HomePage is open")
    public void openHost() throws Exception {
        mainMenu.openMainPage();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(mainMenu.getTitle(), title);

    }

    @When("Top bar is opened")
    public void topMenuisOpened() throws Exception {
        topMenu.waitUntilLoad();
    }

    @Then("Top bar contains items")
    public void top_bar_contains_items(io.cucumber.datatable.DataTable expItemsTable) {

        List<String> expResult = expItemsTable.asList(String.class);
        List<String> actualResult = topMenu.getAllTopMenuItems();
        Assert.assertEquals(expResult, actualResult);
    }

    @Then("Top bar item {string} is selected")
    public void top_bar_menu_item_is_selected(String menu_item) {
        Assert.assertTrue(topMenu.isMenuItemSelected(menu_item));
    }

    @When("Top bar item {string} is clicked")
    public void top_bar_item_is_opened(String menu_item) throws Exception {
        topMenu.clickTopMenuItemByName(menu_item);
    }

    @Then("Title contains {string}")
    public void title_contains(String title_part) {
        Assert.assertTrue(mainMenu.titleContainString(title_part));
    }


}
