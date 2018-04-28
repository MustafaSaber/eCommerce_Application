package com.ecommerce.sw2.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Approve {
    public boolean TestApproveStore(WebDriver driver, String storeName)
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
            driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
            driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-valid']")).clear();
            driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-valid']")).sendKeys(storeName);
            driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

            while(driver.getCurrentUrl().equals("http://localhost:4200/addstore"))
            {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(driver.getCurrentUrl().equals("http://localhost:4200/userhome")) {
                driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

                while (driver.getCurrentUrl().equals("http://localhost:4200/userhome")) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (driver.getCurrentUrl().equals("http://localhost:4200/appstores"))
                {
                    if (driver.getCurrentUrl().equals("http://localhost:4200/appstores")) {
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //System.out.println("hi");
                    driver.findElement(By.xpath("//html//tr[1]/td[2]/button[1]")).click();
                   // System.out.println("hi2");

                    while (driver.getCurrentUrl().equals("http://localhost:4200/appstores")) {
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (driver.getCurrentUrl().equals("http://localhost:4200/userhome"))
                        return true;
                }
            }
        }
        return false;
    }

}
