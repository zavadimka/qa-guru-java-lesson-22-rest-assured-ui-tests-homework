package com.zavadimka.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/user_data.properties")
public interface UserData extends Config {

    @Key("user_name")
    String getUserName();

    @Key("password")
    String getPassword();
}
