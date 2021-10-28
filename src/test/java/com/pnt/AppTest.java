package com.pnt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppTest {
    WebDriver driver;
    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/alichowdhury/IdeaProjects/SeleniumProject/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals("Success!!", "Amazon.com. Spend less. Smile more.", title);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.id("nav-cart-count")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
    }
    @After
    public void after(){
        driver.close();
    }
}
