package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})

public interface WebConfig extends Config {
    @Key("isRemote")
    Boolean getIsRemote();

    @Key("browserSize")
    String getBrowserSize();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remote")
    String getRemote();
}
