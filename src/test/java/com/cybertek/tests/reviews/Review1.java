package com.cybertek.tests.reviews;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Review1 {
    public static void main(String[] args) {

        //to navigate cybertekschool.com with chrome

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cybertekschool.com");







    }
}
