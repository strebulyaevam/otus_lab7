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

    @Then("^Top bar contains items (.*)$")
    public void top_bar_contains_items(List<String> expResult) {

        List<String> actualResult = topMenu.getAllTopMenuItems();
        Assert.assertEquals(expResult, actualResult);
    }

}
