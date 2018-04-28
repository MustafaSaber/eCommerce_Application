package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Model {
    public boolean TestAddModel(WebDriver driver,String modelname, String brandname)
    {
        driver.get("http://localhost:4200/");
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        driver.findElement(By.xpath("//html//div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[1]/input[1]")).sendKeys("n");
        driver.findElement(By.xpath("//html//div[2]/input[1]")).clear();
        driver.findElement(By.xpath("//html//div[2]/input[1]")).sendKeys("n");
        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

        while(driver.getCurrentUrl().equals("http://localhost:4200/login"))
        {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(driver.getCurrentUrl().equals("http://localhost:4200/userhome"))
        {
            driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
            driver.findElement(By.xpath("//html//div[1]/input[1]")).clear();
            driver.findElement(By.xpath("//html//div[1]/input[1]")).sendKeys(modelname);
            driver.findElement(By.xpath("//html//div[2]/input[1]")).clear();
            driver.findElement(By.xpath("//html//div[2]/input[1]")).sendKeys(brandname);
            driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

            while(driver.getCurrentUrl().equals("http://localhost:4200/addmodel"))
            {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(driver.getCurrentUrl().equals("http://localhost:4200/userhome"))
                return true;
        }

        return false;
    }
}
