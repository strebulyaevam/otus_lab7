package lab7;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features.lab7",
        glue = "lab7",
//        tags = "@Test",
        dryRun = false,
        strict = false
)
public class RunnerCucumberTest {
}
