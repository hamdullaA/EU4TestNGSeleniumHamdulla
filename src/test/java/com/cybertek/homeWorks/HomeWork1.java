package com.cybertek.homeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class HomeWork1 {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/imghp?hl=en");
        String titlle=driver.getTitle();
        System.out.println("titlle = " + titlle);
        driver.get("https://www.etsy.com/");
        String titlle2=driver.getTitle();
        System.out.println("title2 = " + titlle2);
        driver.navigate().back();
        String title11=driver.getTitle();
        if (titlle.equals(title11)){
            System.out.println("Verified");
        }else {
            System.out.println("NOT Verified");
        }
        driver.navigate().forward();
        String titlle21=driver.getTitle();
        if(titlle2.equals(titlle21)){
            System.out.println("Verified");
        }else {
            System.out.println("Not Verified");
        }
        driver.quit();

    }
}
