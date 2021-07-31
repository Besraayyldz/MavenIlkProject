package com.techproed;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Day10_DropDownOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void tearDown(){
//        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://Amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Software");

        WebElement search = dropDown.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("Java"+ Keys.ENTER);

        WebElement secenekSay = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(secenekSay.getText());
        Assert.assertTrue(secenekSay.getText().contains("Java"));

    }


}