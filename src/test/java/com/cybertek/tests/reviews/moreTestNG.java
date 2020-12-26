package com.cybertek.tests.reviews;

import org.testng.annotations.Test;

public class moreTestNG {

    @Test(priority = 1)
    public void C(){
        System.out.println("My Third Test Case");

    }

    @Test (priority = 2)
    public void A(){

        System.out.println("My First Test Case");
    }

    @Test (priority = 3)
    public void B(){
        System.out.println("My Second Test Case");
    }

}
