package com.example.testcases;

import com.example.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer (String firstName, String lastName, String postCode, String alertText) throws InterruptedException {

        driver.findElement(By.xpath(or.getProperty("addCustBtn"))).click();

        driver.findElement(By.xpath(or.getProperty("firstname"))).sendKeys(firstName);
        driver.findElement(By.xpath(or.getProperty("lastname"))).sendKeys(lastName);
        driver.findElement(By.xpath(or.getProperty("postcode"))).sendKeys(postCode);

        driver.findElement(By.xpath(or.getProperty("submitBtn"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));
        alert.accept();
    }

    @DataProvider
    public Object[][] getData () throws IOException {

        String sheetName = "AddCustomerTest";
        String fileName = "test_data.xlsx";
        excelReader.readExcel("/home/rony78/Programming/Code/selenium/DataDrivenFramework/src/test/resources/excel/test_data.xlsx", fileName, sheetName);
        Object [][] data;
        data = excelReader.getData();

        return data;
    }
}
