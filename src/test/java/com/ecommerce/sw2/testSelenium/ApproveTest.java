package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ApproveTest {

    Approve approve = new Approve();
    WebDriver driver ;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\FCI\\3.2\\Software Engineering 2\\Assignments\\Assignment#2\\selenium-java-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "approve")
    public static Object[][] a() {
        return new Object[][]{
                {"SaberStore"},
                {"MinaStore"},
                {"SunCity"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "approve")
    public void testTestApproveStore(String storename) throws Exception {
        assertEquals(true,approve.TestApproveStore(driver,storename));
    }

   @AfterTest
    public void end(){
        driver.close();
    }
}