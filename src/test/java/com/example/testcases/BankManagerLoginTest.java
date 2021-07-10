package com.example.testcases;

import com.example.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {

        driver.findElement(By.xpath(or.getProperty("bmlBtn"))).click();
        Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("addCustBtn"))), "Login not successful");
        Thread.sleep(4000);

    }
}
