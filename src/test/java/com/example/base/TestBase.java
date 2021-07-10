package com.example.base;

import com.example.utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public static Properties config = new Properties();
    public static Properties or = new Properties();

    public static FileInputStream file = null;

    public static ExcelReader excelReader = new ExcelReader();

    public static WebDriverWait wait;

    //public static Logger log = Logger.getLogger("devpinoyLogger");

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
            wait = new WebDriverWait(driver, 8);
        }
    }

    public boolean isElementPresent (By by) {

        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
