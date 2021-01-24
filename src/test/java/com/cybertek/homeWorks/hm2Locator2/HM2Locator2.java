package com.cybertek.homeWorks.hm2Locator2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HM2Locator2 {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
       // WebElement acceptBut=driver.findElement(By.xpath("//button[@id='gdpr-banner-accept']"));
        //acceptBut.click();
        WebElement searchBox=driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("cybertek");
       driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement result=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String resultText=result.getText();
        //System.out.println("resultText = " + resultText);
        String numberOnly = resultText.replaceAll("[^0-9]", "");
        System.out.println("numbe of results: " + numberOnly);
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement searchBox=driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement result=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String resultText=result.getText();
        if(resultText.contains("Selenium")){
            System.out.println("PASS");
        }else {
            System.out.println("Fail");
        }
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void test3(){
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchBox.sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//i[contains(text(),'Search')]")).click();
        WebElement seleniumSoftware=driver.findElement(By.xpath(" (//span[@class='searchmatch'])[1] "));
        seleniumSoftware.click();
        String curenturl=driver.getCurrentUrl();
        System.out.println("curenturl = " + curenturl);
        if(curenturl.endsWith("Selenium_(software)")){
           System.out.println("PASS");
        }else {
           System.out.println("FAIL");
        }
        driver.quit();



    }
}
