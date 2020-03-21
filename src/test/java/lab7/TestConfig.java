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

    private enum Browser{chrome, firefox};

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
        Browser browser;
        try {
            browser = Browser.valueOf(config.browser().toLowerCase());
        } catch (IllegalArgumentException e) {
            Log.error("Unknown browser " + config.browser(), e);
            throw e;
        }

        WebDriver driver = null;
        if (browser == Browser.chrome) {
            WebDriverManager.chromedriver().setup();
            driver = new org.openqa.selenium.chrome.ChromeDriver();
        } else if (browser == Browser.firefox) {
            WebDriverManager.firefoxdriver().setup();
            driver = new org.openqa.selenium.firefox.FirefoxDriver();
        } else {
            Log.error("Unknown browser type " + browser.name());
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
