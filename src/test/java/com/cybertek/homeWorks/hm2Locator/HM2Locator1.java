package com.cybertek.homeWorks.hm2Locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HM2Locator1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement homeButton=driver.findElement(By.xpath("//a[@class='nav-link']"));
        String homeText=homeButton.getText();
        System.out.println("homeText = " + homeText);
        WebElement forgetPasswordButton=driver.findElement(By.xpath("//h2[contains(text(),'Forgot Password')]"));
        String forgetPassText=forgetPasswordButton.getText();
        System.out.println("forgetPassText = " + forgetPassText);
        WebElement Email=driver.findElement(By.xpath("//label[@for='email']"));
        String emailText=Email.getText();
        System.out.println("emailText = " + emailText);
        WebElement emailInputBox=driver.findElement(By.xpath("//input[@name='email']"));
        emailInputBox.sendKeys("hamdulla@gmail.com");
        WebElement retrievePasswordButton=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        String retrievePasswordText=retrievePasswordButton.getText();
        System.out.println("retrievePasswordText = " + retrievePasswordText);
        Thread.sleep(2000);
        driver.quit();
    }
}
