package com.cybertek.homeWorks.hm3CheckBox;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CkeckBoxVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkBox=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        checkBox.click();
        WebElement displayed=driver.findElement(By.xpath("//div[contains(text(),'Success - Check box is checked')]"));
        String displayedText=displayed.getText();
        Assert.assertTrue(displayedText.equals("Success - Check box is checked"));
        Assert.assertTrue(checkBox.isSelected(),"checkBox is checked");
        Thread.sleep(2000);
        checkBox.click();
        Assert.assertFalse(displayed.getText().equals("Success - Check box is checked"));

    }
    @Test
    public void test2(){
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkAll=driver.findElement(By.xpath("//input[@id='check1']"));
        String verifyCheckAll=checkAll.getAttribute("value");
        Assert.assertTrue(verifyCheckAll.equals("Check All"));
        checkAll.click();
        WebElement check1=driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]"));
        WebElement check2=driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]"));
        WebElement check3=driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]"));
        WebElement check4=driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));
        Assert.assertTrue(check1.isSelected(),"option1 button is checked");
        Assert.assertTrue(check2.isSelected(),"option2 button is checked");
        Assert.assertTrue(check3.isSelected(),"option3 button is checked");
        Assert.assertTrue(check4.isSelected(),"option4 button is checked");
        WebElement uncheckAll=driver.findElement(By.xpath("//input[@type='button']"));
        String verifyUnCheckAll=uncheckAll.getAttribute("value");
        Assert.assertTrue(verifyUnCheckAll.equals("Uncheck All"));
        /*
         // Find total checkbox count by.classname
        int checkBoxCount = driver.findElements(By.className("cb1-element")).size();
​
        for (int i = 1; i <= checkBoxCount; i++) {
            //      <input  type="checkbox"  class="cb1-element"  >
            WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'][@class='cb1-element'])[" + i + "]"));
            Assert.assertTrue(checkbox.isSelected(), "verify checkbox " + i + " is selected");
        }
         */

    }

}
