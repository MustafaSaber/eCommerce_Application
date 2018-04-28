package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StoreTest {
    Store store = new Store();
    WebDriver driver ;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\FCI\\3.2\\Software Engineering 2\\Assignments\\Assignment#2\\selenium-java-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "store1")
    public static Object[][] s1() {
        return new Object[][]{
                {"beatsAudio"},
                {"Whatsapp"},
                {"CityStars"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "store1")
    public void testTestAddStore(String storename) throws Exception {
        assertEquals(true,store.TestAddStore(driver,storename));
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}