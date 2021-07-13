package com.example.utilities;

import com.example.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static void captureScreenShot () throws IOException {

        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenFile, new File("/home/rony78/Programming/Code/selenium/DataDrivenFramework/target/error.jpg"));
    }
}
