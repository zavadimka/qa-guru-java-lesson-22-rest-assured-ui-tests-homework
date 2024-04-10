package com.zavadimka.tests;

import com.zavadimka.config.UserData;
import org.aeonbits.owner.ConfigFactory;

public class TestUserData {

    static UserData userLoginConfig = ConfigFactory.create(UserData.class, System.getProperties());
    public static String userName;
    public static String password;


    public static void getUserTestLoginData() {
        userName = userLoginConfig.getUserName();
        password = userLoginConfig.getPassword();
    }
}