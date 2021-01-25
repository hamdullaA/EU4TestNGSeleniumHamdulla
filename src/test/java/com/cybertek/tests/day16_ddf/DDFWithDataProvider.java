package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
    @DataProvider
    public Object [][] testData(){
        String [][] data={
                {"The Walking dead","10"},
                {"Friends","10"},
                {"Prison Break","8"},
                {"GameOfThrones","7"},
                {"Lost","6"},
                {"How I Met Your Mother","7"},
                {"Sherlok","8"}
        };
        return data;
    }
    @Test(dataProvider = "testData")
    public void test1(String tvShow, String rating){
        System.out.println("TV show: "+tvShow+" Rating: "+rating);


    }
}
