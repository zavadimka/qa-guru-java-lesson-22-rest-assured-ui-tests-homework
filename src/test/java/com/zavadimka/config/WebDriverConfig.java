package com.zavadimka.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${driver}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("webdriver.remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getDriverRemoteUrl();

    @Key("webdriver.baseUrl")
    @DefaultValue("https://demoqa.com")
    String getDriverBaseUrl();

    @Key("webdriver.browser")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("webdriver.browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("webdriver.browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();
}
