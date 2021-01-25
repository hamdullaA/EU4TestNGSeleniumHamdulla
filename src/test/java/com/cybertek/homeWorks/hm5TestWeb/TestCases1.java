package com.cybertek.homeWorks.hm5TestWeb;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
//based on storemanager51
public class TestCases1 extends TestBase {
    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        WebElement options=driver.findElement(By.xpath("//div[contains(text(),'Options')]"));
        //System.out.println("options.isDisplayed() = " + options.isDisplayed());
        Assert.assertTrue(options.isDisplayed(),"\"Options\" is displayed");
    }
    @Test
    public void test2(){
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        WebElement pageNumber=driver.findElement(By.xpath("//input[@value='1']"));
        String value=pageNumber.getAttribute("value");
        //System.out.println("value = " + value);
        Assert.assertTrue(value.equals("1"),"page number is equals to \"1\"");


    }
    @Test
    public void test3(){
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        WebElement choose=driver.findElement(By.xpath("(//span[@class='caret'])[9]"));
        choose.click();
        WebElement perPageNumber25=driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]"));
        String value=perPageNumber25.getText();
        System.out.println("value = " + value);
        Assert.assertTrue(value.equals("25"),"per page number is equals to \"25\"");

    }
    @Test
    public void test4() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        WebElement records=driver.findElement(By.xpath("//label[contains(text(),'Total of 32 records')]"));


        String recordNumber =records.getText() .replaceAll("[^0-9]", "");
        int numOfrecord=Integer.parseInt(recordNumber);
        System.out.println("numOfrecord = " + numOfrecord);
        WebElement choose=driver.findElement(By.xpath("(//span[@class='caret'])[9]"));
        choose.click();
        WebElement button50=driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]"));
        button50.click();
        Thread.sleep(2000);

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table//tbody//tr"));
        int rowNumbers=allRowsWithoutHeader.size();
        System.out.println("rowNumbers = " + rowNumbers);
        Assert.assertTrue(numOfrecord==rowNumbers,"number of calendar events is equals to number of records");



    }
}
