package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest1 extends TestBase {
    /**
     * open the chrome
     * go to qa.transmuda  (qa1.vytrack)
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email demo.O@maildemo.com  (mbrackstone9@example.com)
     * verify that full name is Demo Omed (Mariam Brackstone)
     * verify that email is demo.O@maildemo.com  (mbrackstone9@example.com)
     * verify that phone number is 1234567890 (+18982323434)
     */
    @Test
    public void contactDetailsTest(){
        extentLogger=report.createTest("Contact Info Verirification");
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a Sales Manager");
        WebElement Advanced=driver.findElement(By.id("details-button"));
        Advanced.click();
        WebElement ProceedToPage=driver.findElement(By.id("proceed-link"));
        ProceedToPage.click();
        loginPage.login(username,password);
        extentLogger.info("Navigate to --> Customers > Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");
        // email locator //td[contains(text(),'demo.O@maildemo.com')]
        // email  //td[contains(text(),'demo.O@maildemo.com')][@data-column-label='Email']
        ContactsPage contactsPage=new ContactsPage();
        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("demo.O@maildemo.com").click();
        //full name locator h1.username
        //phone number ,emaol locator  a.phone   a.email
        ContactInfoPage contactInfoPage=new ContactInfoPage();
        String expectedFullName="Demo Omed";
        String actualFullName=contactInfoPage.fullName.getText();
        extentLogger.info("Verify Full Name is "+expectedFullName);

        Assert.assertEquals(actualFullName,expectedFullName,"verify fullName");
        extentLogger.info("Verify Full Name is demo.O@maildemo.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"demo.O@maildemo.com","verify email");
        extentLogger.info("Verify Full Name is 1234567890");
        Assert.assertEquals(contactInfoPage.phone.getText(),"1234567890","verify phoneNumber");
        extentLogger.pass("PASSED");


    }
}
