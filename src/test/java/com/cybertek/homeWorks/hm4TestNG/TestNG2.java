package com.cybertek.homeWorks.hm4TestNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test
    //tempmailadress.com test
    public void testCase6(){
        driver.get("https://www.tempmailaddress.com/");
        WebElement copy=driver.findElement(By.xpath("//a[@style='color:white;']"));
        copy.click();
        WebElement email=driver.findElement(By.xpath("//span[@id='email']"));
        String emailAdress=email.getText();
        //System.out.println("emailAdress = " + emailAdress);
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement signUp=driver.findElement(By.linkText("Sign Up For Mailing List"));
        signUp.click();
        driver.findElement(By.name("full_name")).sendKeys("Hamdulla Aksu");
        driver.findElement(By.xpath("//*[@*='email']")).sendKeys(emailAdress);
        driver.findElement(By.name("wooden_spoon")).click();
        WebElement displayed=driver.findElement(By.name("signup_message"));
        Assert.assertTrue(displayed.isDisplayed(),"message is displayed");
        driver.get("https://www.tempmailaddress.com/");
        WebElement receivedEmail=driver.findElement(By.xpath("(//td[@class='from'])[1]"));
        receivedEmail.click();
        WebElement emailFrom=driver.findElement(By.id("odesilatel"));

        Assert.assertTrue(emailFrom.getText().equals("do-not-reply@practice.cybertekschool.com"),"verify email");

        WebElement subjectMessage=driver.findElement(By.id("predmet"));
        Assert.assertTrue(subjectMessage.isDisplayed(),"verify message");



    }
    @Test
    public void testCase7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

    }
    @Test
    public void testCase8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//*[@*='Submit']")).click();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(message.getText().equals("You selected: United States of America"),"verify message");

    }
}
