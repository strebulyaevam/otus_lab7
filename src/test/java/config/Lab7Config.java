package config;

import org.aeonbits.owner.Config;

public interface Lab7Config extends Config {
    @DefaultValue("Chrome")
    String browser();

    @DefaultValue("https://habr.com/ru/")
    String hostname();
}
