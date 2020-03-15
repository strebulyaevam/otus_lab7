package lab7;

import config.Lab7Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "lab7")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class TestConfig {

    private static Logger Log = LogManager.getLogger(TestConfig.class);

    @Autowired
    Lab7Config config;

    @Autowired
    WebDriver driver;

    @Bean
    public Lab7Config getConfig() {
        Lab7Config cfg = ConfigFactory.create(Lab7Config.class);
        return cfg;
    }

    @Bean
    public WebDriver getDriver() {
        WebDriver driver = null;
        if ("Chrome".equals(config.browser())) {
            WebDriverManager.chromedriver().setup();
            driver = new org.openqa.selenium.chrome.ChromeDriver();
        } else if ("Firefox".equals(config.browser())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new org.openqa.selenium.firefox.FirefoxDriver();
        } else {
            Log.error("Unknown browser type");
        }

        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

/*    @PreDestroy
    public void closeDriver() {
        if (driver != null){
            Log.info("Quit from browser");
            driver.quit();
        }
    }*/
}
