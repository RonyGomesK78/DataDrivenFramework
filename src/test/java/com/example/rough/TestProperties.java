package com.example.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {

        Properties config = new Properties();
        Properties or = new Properties();

        FileInputStream file = new FileInputStream("/home/rony78/Programming/Code/selenium/DataDrivenFramework/src/test/resources/properties/Config.properties");
        config.load(file);

        file = new FileInputStream("/home/rony78/Programming/Code/selenium/DataDrivenFramework/src/test/resources/properties/OR.properties");
        or.load(file);

        System.out.println(config.getProperty("browser"));
        System.out.println(or.getProperty("loginBtn"));
    }
}
