package com.cybertek.tests.reviews;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class moreDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");
        //1. locate the dropdown with name
        WebElement dropdownElement = driver.findElement(By.name("Languages"));

        //2. create Select object
        Select langDropdown = new Select(dropdownElement);

        //get the default selection
        //System.out.println("Selected"+langDropdown.getFirstSelectedOption().getText());

        langDropdown.selectByIndex(1);

        System.out.println("Selected "+langDropdown.getFirstSelectedOption().getText());


        langDropdown.selectByIndex(0);
        langDropdown.selectByIndex(3);
        langDropdown.selectByIndex(4);

        System.out.println("Selected "+langDropdown.getFirstSelectedOption().getText());

        //get all selected options
        List<WebElement> allSelectedOptions = langDropdown.getAllSelectedOptions();

        for (WebElement option : allSelectedOptions) {
            System.out.println(option.getText());
        }

        //deselect all options

        langDropdown.deselectAll();
    }
}
