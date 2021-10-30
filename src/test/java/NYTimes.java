package com.pnt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NYTimes {
    WebDriver driver;
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/alichowdhury/IdeaProjects/SeleniumProject/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.nytimes.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals("Success!!", "The New York Times - Breaking News, US News, World News and Videos", title);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.className("css-1q6mid5 eieewvv0")).click();
    }
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.className("css-1axrnfw")).sendKeys("usa news");
        driver.findElement(By.id("search-submit")).click();
    }
    @After
    public void after(){
        driver.close();
    }
}