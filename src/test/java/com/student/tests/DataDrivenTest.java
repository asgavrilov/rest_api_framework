package com.student.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class DataDrivenTest {

    @DataProvider
    public static Object[][] dataProviderAdd() {
        return new Object[][]{
                {0, 1},
                {1, 2},
                {3, 4}
        };
    }

    @UseDataProvider("dataProviderAdd")
    @Test
    public void add2Numbers(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    @Test
    public void printSmth() {
        System.out.println("Hi, tester");
    }

}
