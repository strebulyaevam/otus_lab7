package Steps;

import io.cucumber.java.en.Given;

public class MainPageSteps {
    @Given("Browser \"([^\"]*)\"$\" is open")
    public void openBrowser(String browser) {
        mainPage.openTopic(index - 1);
    }

}
