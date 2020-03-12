package Steps;

import config.Lab7Config;
import driverconfig.DriverServies;
import io.cucumber.java.After;
import io.cucumber.java.Before;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.springframework.test.context.ContextConfiguration;



public class CommonSteps {

    Lab7Config cfg;
    DriverServies driverServies;

    //    @ContextConfiguration(classes = Config.class)
     @Before
      public void before() {
         cfg = ConfigFactory.create(Lab7Config.class);
         driverServies = new DriverServies();
     }

      @After
       public void after() {
          driverServies.closeDriver();
      }
}
