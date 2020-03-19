package lab7.steps;

import io.cucumber.java.en.Then;
import lab7.pageobjects.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class MainMenuSteps {

    @Autowired
    MainMenu mainMenu;

    @Then("Main menu contains items")
    public void main_menu_contains_items(io.cucumber.datatable.DataTable expItemsTable) {

        List<String> expResult = expItemsTable.asList(String.class);
        List<String> actualResult = mainMenu.getAllMainMenuItems();
        Assert.assertEquals(expResult, actualResult);
    }

}
