package config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:config/${env}.properties")

public interface RegistrationConfig extends Config {
    @Key("first_name")
    @DefaultValue("defaultFirstName")
    String firstName();
    @Key("last_name")
    @DefaultValue("defaultLastName")
    String lastName();
}
