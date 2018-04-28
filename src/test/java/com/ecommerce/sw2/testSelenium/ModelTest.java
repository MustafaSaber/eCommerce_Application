package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ModelTest {
    Model model = new Model();
    WebDriver driver ;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\FCI\\3.2\\Software Engineering 2\\Assignments\\Assignment#2\\selenium-java-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "model")
    public static Object[][] m1() {
        return new Object[][]{
                {"boyFriend","Cizaro"},
                {"mac","apple"},
                {"lapHp","hp"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "model")
    public void testTestAddModel(String modelname,String brandname) throws Exception {
        assertEquals(true,model.TestAddModel(driver,modelname,brandname));
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}