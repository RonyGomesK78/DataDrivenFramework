package com.example.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public Properties config = new Properties();
    public Properties or = new Properties();

    private FileInputStream file = null;

    @BeforeSuite
    public void setup() {
        if (driver == null) {

            try {
                file = new FileInputStream("/home/rony78/Programming/Code/selenium/DataDrivenFramework/src/test/resources/properties/Config.properties");
                config.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                file = new FileInputStream("/home/rony78/Programming/Code/selenium/DataDrivenFramework/src/test/resources/properties/OR.properties");
                or.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (config.getProperty("browser").equals("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (config.getProperty("browser").equals("chrome")) {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

            driver.get(config.getProperty("test_site_url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
