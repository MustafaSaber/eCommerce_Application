package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductTest {
    Product product = new Product();
    WebDriver driver ;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\FCI\\3.2\\Software Engineering 2\\Assignments\\Assignment#2\\selenium-java-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "product")
    public static Object[][] p() {
        return new Object[][]{
                {"XL","pantalon","100","3"},
                {"S blue","blouse","500","6"},
                {"laptop i5","pavilion","15900","10"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "product")
    public void testTestRegister(String productName,String model,String price,String items) throws Exception {
        assertEquals(true,product.TestAddProduct(driver,productName,model,price,items));
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}