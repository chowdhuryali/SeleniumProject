package com.pnt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Walmart {
    WebDriver driver;
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/alichowdhury/IdeaProjects/SeleniumProject/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.walmart.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals("Success!!", "Walmart.com | Save Money. Live Better", title);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.className("b")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.className("b--none f5 flex-auto lh-solid sans-serif br-pill")).sendKeys("learn selenium");
        driver.findElement(By.className("ld ld-Search absolute")).click();
    }
    @After
    public void after(){
        driver.close();
    }
}

