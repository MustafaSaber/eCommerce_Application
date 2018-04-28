package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    public boolean TestLogIn(WebDriver driver, String username, String password)
    {
        driver.get("http://localhost:4200/");
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        driver.findElement(By.xpath("//html//div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[1]/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("//html//div[2]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[2]/input[1]")).sendKeys(password);
        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

        // driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        while(driver.getCurrentUrl().equals("http://localhost:4200/login"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(driver.getCurrentUrl().equals("http://localhost:4200/userhome"))
            return true;

        return false;
    }

}
