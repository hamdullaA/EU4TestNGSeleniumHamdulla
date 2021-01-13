package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");

        System.out.println("browserType = " + browserType);

        String url = ConfigurationReader.get("url");

        System.out.println("url = " + url);


    }

    @Test
    public void OpenBrowserWithConf(){

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        WebElement Advanced=driver.findElement(By.id("details-button"));
        Advanced.click();
        WebElement ProceedToPage=driver.findElement(By.id("proceed-link"));
        ProceedToPage.click();

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.TAB);

    }


}
