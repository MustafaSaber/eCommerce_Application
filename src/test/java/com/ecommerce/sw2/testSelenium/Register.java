package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    public boolean TestRegister(WebDriver driver,String name,String email, String username, String password)
    {
        driver.get("http://localhost:4200/");
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        driver.findElement(By.xpath("//html//div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[1]/input[1]")).sendKeys(username);

        driver.findElement(By.xpath("//html//div[2]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[2]/input[1]")).sendKeys(name);

        driver.findElement(By.xpath("//html//div[3]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[3]/input[1]")).sendKeys(email);

        driver.findElement(By.xpath("//html//div[4]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[4]/input[1]")).sendKeys(password);

        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();


        while(driver.getCurrentUrl().equals("http://localhost:4200/op"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(driver.getCurrentUrl().equals("http://localhost:4200/login"))
            return true;

        return false;
    }

}
