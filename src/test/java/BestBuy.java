package com.pnt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BestBuy {
    WebDriver driver;
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/alichowdhury/IdeaProjects/SeleniumProject/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals("Success!!", "Best Buy | Official Online Store | Shop Now & Save", title);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/header/div[1]/div/div[3]/div[1]/div/div/div/div/a")).click();
    }
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.id("gh-search-input")).sendKeys("usa news");
        driver.findElement(By.className("header-search-button")).click();
    }
    @After
    public void after(){
        driver.close();
    }
}
