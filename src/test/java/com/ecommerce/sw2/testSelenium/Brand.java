package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Brand {
    public boolean TestAddBrand(WebDriver driver, String brandname)
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
            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
            driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-valid']")).clear();
            driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-valid']")).sendKeys(brandname);
            driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

            while(driver.getCurrentUrl().equals("http://localhost:4200/addbrand"))
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
