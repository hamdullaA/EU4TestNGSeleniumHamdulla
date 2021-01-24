package com.cybertek.homeWorks.hm5TestWeb;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends TestBase {
    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        WebElement Advanced=driver.findElement(By.id("details-button"));
        Advanced.click();
        WebElement ProceedToPage=driver.findElement(By.id("proceed-link"));
        ProceedToPage.click();
        loginPage.login(username,password);
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        WebElement options=driver.findElement(By.xpath("//div[contains(text(),'Options')]"));
        //System.out.println("options.isDisplayed() = " + options.isDisplayed());
        Assert.assertTrue(options.isDisplayed(),"\"Options\" is displayed");

    }
}
