package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();
        WebElement Advanced=driver.findElement(By.id("details-button"));
        Advanced.click();
        WebElement ProceedToPage=driver.findElement(By.id("proceed-link"));
        ProceedToPage.click();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();
        WebElement Advanced=driver.findElement(By.id("details-button"));
        Advanced.click();
        WebElement ProceedToPage=driver.findElement(By.id("proceed-link"));
        ProceedToPage.click();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }


}
