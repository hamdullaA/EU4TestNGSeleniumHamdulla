package com.cybertek.homeWorks.hm5TestWeb;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase2 extends TestBase {
@Test
    public void test1(){
    LoginPage loginPage=new LoginPage();
    String username = ConfigurationReader.get("storemanager_username");
    String password = ConfigurationReader.get("storemanager_password");
    loginPage.login(username,password);
    new DashboardPage().navigateToModule("Activities","Calendar Events");
    WebElement options=driver.findElement(By.xpath("//div[contains(text(),'Options')]"));
    Assert.assertTrue(options.isDisplayed(),"\"Options\" is displayed");

}
@Test
    public void test2(){
    LoginPage loginPage=new LoginPage();
    String username = ConfigurationReader.get("storemanager_username");
    String password = ConfigurationReader.get("storemanager_password");
    loginPage.login(username,password);
    new DashboardPage().navigateToModule("Activities","Calendar Events");
    WebElement page=driver.findElement(By.xpath("//input[@type='number']"));
    String value=page.getAttribute("value");
    System.out.println("value = " + value);
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
    WebElement records=driver.findElement(By.xpath("//label[contains(text(),'Total of 4059 records')]"));
    String recordNumber =records.getText() .replaceAll("[^0-9]", "");
    int recordNumbers=Integer.parseInt(recordNumber);
    System.out.println("recordNumbers = " + recordNumbers);
    WebElement choose=driver.findElement(By.xpath("(//span[@class='caret'])[9]"));
    choose.click();
    WebElement button100=driver.findElement(By.xpath("(//a[@class='dropdown-item'])[4]"));
    button100.click();
    Thread.sleep(2000);
    List<WebElement> RowsPage1WithoutHeader = driver.findElements(By.xpath("//table//tbody//tr"));
    int rowNumbers1=RowsPage1WithoutHeader.size();
    System.out.println("rowNumbers1 = " + rowNumbers1);
    WebElement pageOf=driver.findElement(By.xpath("(//label[@class='dib'])[2]"));
    String totalPage =pageOf.getText() .replaceAll("[^0-9]", "");
    int totalPageNums=Integer.parseInt(totalPage);
    System.out.println("totalPageNums = " + totalPageNums);

     WebElement page=driver.findElement(By.xpath("//input[@type='number']"));
     //page.clear();

    page.sendKeys("4");
     WebElement next=driver.findElement(By.xpath("//i[contains(text(),'Next')]"));
     next.click();
    Thread.sleep(2000);
    List<WebElement> RowsLastPageWithoutHeader = driver.findElements(By.xpath("//table//tbody//tr"));
    int rowNumbersLastPage=RowsLastPageWithoutHeader.size();
    int totalRows=rowNumbers1*(totalPageNums-1)+rowNumbersLastPage;
    System.out.println("totalRows = " + totalRows);
     Assert.assertTrue(recordNumbers==totalRows,"number of calendar events is equals to number of records");







}
@Test
   public void test5(){
    LoginPage loginPage=new LoginPage();
    String username = ConfigurationReader.get("storemanager_username");
    String password = ConfigurationReader.get("storemanager_password");
    loginPage.login(username,password);
    new DashboardPage().navigateToModule("Activities","Calendar Events");
    WebElement checkBox=driver.findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]"));
    checkBox.click();
    WebElement checkAll=driver.findElement(By.xpath("//body/ul/li[1]/a"));
    checkAll.click();
    


}
}
