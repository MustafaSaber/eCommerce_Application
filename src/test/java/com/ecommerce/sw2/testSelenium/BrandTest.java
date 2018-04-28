package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BrandTest {
    Brand brand = new Brand();
    WebDriver driver ;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\FCI\\3.2\\Software Engineering 2\\Assignments\\Assignment#2\\selenium-java-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "brand")
    public static Object[][] b1() {
        return new Object[][]{
                {"Dove"},
                {"addidas"},
                {"Teranova"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "brand")
    public void testTestAddBrand(String brandname) throws Exception {
        assertEquals(true,brand.TestAddBrand(driver,brandname));
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}