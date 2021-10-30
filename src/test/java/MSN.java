package com.pnt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MSN {
    WebDriver driver;
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/alichowdhury/IdeaProjects/SeleniumProject/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.msn.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals("Success!!", "MSN | Outlook, Office, Skype, Bing, Breaking News, and Latest Videos", title);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.id("28")).click();
    }
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.id("srchfrm")).sendKeys("learn selenium");
        driver.findElement(By.id("sb_form_go")).click();
    }
    @After
    public void after(){
        driver.close();
    }
}

