package config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({"classpath:config/${environment}.properties",
        "classpath:config/stage.properties"})

public interface RegistrationConfig extends Config {
    @Key("first.name")
    String firstName();
    @Key("last.name")
    String lastName();

}
