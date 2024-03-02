package config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:config/${environment}.properties")

public interface RegistrationConfig extends Config {
    @Key("first_name")
    String firstName();
    @Key("last_name")
    String lastName();
}
