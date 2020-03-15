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

//        techs.forEach(tech -> System.out.println("I can " + tech));

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
    }

}
