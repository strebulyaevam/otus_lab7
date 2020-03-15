package lab7.steps;

import config.Lab7Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lab7.TestConfig;
import lab7.pageobjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
public class CommonSteps {

    @Autowired
    Lab7Config cfg;

    private static Logger Log = LogManager.getLogger(CommonSteps.class);


     @Before
      public void before() {
     }

      @After
       public void after() {
      }

}
