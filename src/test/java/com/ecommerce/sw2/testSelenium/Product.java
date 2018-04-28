package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product {
    public boolean TestAddProduct(WebDriver driver, String productName,String modelName,String price,String noOfItems)
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
            driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
            driver.findElement(By.xpath("//html//tr[2]/td[2]/button[1]")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-info'][contains(text(),'Add Product')]")).click();

            driver.findElement(By.xpath("//html//div[1]/input[1]")).clear();
            driver.findElement(By.xpath("//html//div[1]/input[1]")).sendKeys(productName);

            driver.findElement(By.xpath("//html//div[2]/input[1]")).clear();
            driver.findElement(By.xpath("//html//div[2]/input[1]")).sendKeys(modelName);

            driver.findElement(By.xpath("//html//div[3]/input[1]")).clear();
            driver.findElement(By.xpath("//html//div[3]/input[1]")).sendKeys(price);

            driver.findElement(By.xpath("//html//div[4]/input[1]")).clear();
            driver.findElement(By.xpath("//html//div[4]/input[1]")).sendKeys(noOfItems);

            driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

            while(driver.getCurrentUrl().equals("http://localhost:4200/addproduct"))
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
