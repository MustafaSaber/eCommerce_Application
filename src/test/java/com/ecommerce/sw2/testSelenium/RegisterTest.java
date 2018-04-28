package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegisterTest {
    Register register = new Register();
    WebDriver driver ;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\FCI\\3.2\\Software Engineering 2\\Assignments\\Assignment#2\\selenium-java-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "reg")
    public static Object[][] r1() {
        return new Object[][]{
                {"z","z","z","z"},
                {"q","q","q","q"},
                {"c","c","c","c"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "reg")
    public void testTestRegister(String name,String email,String username,String password) throws Exception {
        assertEquals(true,register.TestRegister(driver,name,email,username,password));
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}