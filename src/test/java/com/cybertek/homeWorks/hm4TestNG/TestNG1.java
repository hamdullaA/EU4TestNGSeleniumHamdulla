package com.cybertek.homeWorks.hm4TestNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG1 {
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
    public void testCase1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //WebElement registrationForm=driver.findElement(By.xpath("//a[contains(text(),'Registration Form')]"));
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement birthdayBox=driver.findElement(By.xpath("//input[@name='birthday']"));
        birthdayBox.sendKeys("wrong_dob");
        WebElement warningMes=driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
       String text=warningMes.getText();
        //System.out.println(text);
       Assert.assertTrue(text.equals("The date of birth is not valid"));


    }
    @Test
    public void testCase2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement cLanguage=driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));
        cLanguage.click();
        Assert.assertEquals(cLanguage.getText(),"c++");
        //Assert.assertTrue(cLanguage.isDisplayed(),"c++ is displayed");
        WebElement java=driver.findElement(By.xpath("(//label[@class='form-check-label'])[2]"));
        java.click();
        Assert.assertTrue(java.isDisplayed(),"java is displayed");
        WebElement JavaScript=driver.findElement(By.xpath("(//label[@class='form-check-label'])[3]"));
        JavaScript.click();
        Assert.assertTrue(JavaScript.isDisplayed(),"JavaScript is displayed");

    }
    @Test
    public void testCase3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement firstNameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("a");
        WebElement displayedMes=driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        Assert.assertTrue(displayedMes.isDisplayed(),"first name must be more than 2 and less than 64 characters long");


    }
    @Test
    public void testCase4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement lastNameBox=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("b");
        WebElement displayedMes=driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        Assert.assertTrue(displayedMes.isDisplayed(),"The last name must be more than 2 and less than 64 characters long");


    }
    @Test
    public void testCase5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement firstNameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("hamdulla");
        WebElement lastNameBox=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("aksu");
        WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("hebibulla");
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("hamdulla@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("aksu12345");
        WebElement phone=driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("123-123-1111");
        WebElement gender=driver.findElement(By.xpath("//input[@value='male']"));
        gender.click();
        WebElement birthdayBox=driver.findElement(By.xpath("//input[@name='birthday']"));
        birthdayBox.sendKeys("01/01/2021");
        WebElement department=driver.findElement(By.xpath("//select[@name='department']"));
        Select departmentDropdown = new Select(department);
        departmentDropdown.selectByVisibleText("Department of Engineering");
        WebElement job=driver.findElement(By.xpath("//select[@name='job_title']"));
        Select jobTitle = new Select(department);
        jobTitle.selectByIndex(5);
        WebElement java=driver.findElement(By.xpath("(//label[@class='form-check-label'])[2]"));
        java.click();
        WebElement signUpBut=driver.findElement(By.xpath("//button[@type='submit']"));
        signUpBut.click();
        WebElement displayedMes=driver.findElement(By.xpath("//p"));
        System.out.println("displayedMes.isDisplayed() = " + displayedMes.isDisplayed());
        Assert.assertTrue(displayedMes.isDisplayed(),"You've successfully completed registration!");






    }
}
