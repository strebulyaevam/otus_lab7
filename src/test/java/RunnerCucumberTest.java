import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/lab7/MainMenu.feature",
        glue = "Steps",
        tags = "@all",
        dryRun = false,
        strict = false
)
public class RunnerCucumberTest {
}
