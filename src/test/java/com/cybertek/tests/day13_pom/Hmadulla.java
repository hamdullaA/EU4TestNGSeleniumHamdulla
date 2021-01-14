package com.cybertek.tests.day13_pom;

import com.cybertek.pages.DashboardPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hmadulla extends TestBase {
    @Test
    public void OpenBrowserWithConf(){

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        WebElement Advanced=driver.findElement(By.id("details-button"));
        Advanced.click();
        WebElement ProceedToPage=driver.findElement(By.id("proceed-link"));
        ProceedToPage.click();

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);
        /*WebElement Fleet=driver.findElement(By.xpath("//header/div[@id='main-menu']/ul[1]/li[1]/a[1]/span[1]"));
        Fleet.click();
        WebElement Vehicle=driver.findElement(By.xpath("//header/div[@id='main-menu']/ul[1]/li[1]/a[1]/span[1]"));
        Vehicle.click();

         */
       DashboardPage dashboardPage = new DashboardPage();

        //String actualSubtitle = dashboardPage.getPageSubTitle();

        //Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify subtitle");

        dashboardPage.navigateToModule("Fleet","Vehicles");
        BrowserUtils.waitFor(2);




    }
}
