package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        WebElement Advanced=driver.findElement(By.id("details-button"));
        Advanced.click();
        WebElement ProceedToPage=driver.findElement(By.id("proceed-link"));
        ProceedToPage.click();

        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");

    }
}
