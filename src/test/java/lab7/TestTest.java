package lab7;

import config.Lab7Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TestTest {

    @Autowired
    Lab7Config cfg;

    @Test
    public void test() {
        System.out.println(cfg.browser());
    }
}
