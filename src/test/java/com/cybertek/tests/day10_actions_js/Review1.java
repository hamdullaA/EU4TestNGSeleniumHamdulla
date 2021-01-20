package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Review1 {
    WebDriver driver;
    @BeforeMethod

    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
@Test
    public void test1() throws InterruptedException {
    driver.get("https://www.seleniumeasy.com/test");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[.='No, thanks!']")).click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000)");
    driver.findElement(By.xpath("//a[contains(text(),'Progress Bars & Sliders')]")).click();
    driver.findElement(By.xpath("//div[@class='container-fluid text-center']//*[text()='Drag & Drop Sliders']")).click();
    js.executeScript("window.scrollBy(0,500)");
    WebElement blue=driver.findElement(By.xpath("(//input[@type='range'])[2]"));
    Actions actions=new Actions(driver);
    actions.dragAndDropBy(blue,200,0).build().perform();
    Thread.sleep(2000);

}
}
