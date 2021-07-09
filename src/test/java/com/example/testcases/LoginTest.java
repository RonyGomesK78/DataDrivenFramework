package com.example.testcases;

import com.example.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {

        driver.findElement(By.xpath(or.getProperty("bmlBtn"))).click();
        Thread.sleep(4000);

    }
}
