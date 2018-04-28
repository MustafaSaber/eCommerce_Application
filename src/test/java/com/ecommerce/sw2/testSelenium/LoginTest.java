package com.ecommerce.sw2.testSelenium;

import com.ecommerce.sw2.Models.Services.UserServiceImpTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static org.testng.Assert.*;

public class LoginTest {
    Login log = new Login();
    WebDriver driver ;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\FCI\\3.2\\Software Engineering 2\\Assignments\\Assignment#2\\selenium-java-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "log1")
    public static Object[][] l1() {
        return new Object[][]{
                {"n","n"},
                {"m","m"},
                {"s","s"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "log1")
    public void testTestLogIn(String username,String password) throws Exception {
        assertEquals(true,log.TestLogIn(driver,username,password));
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}