package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
      //  driver.quit();
    }

    @Before
    public void beforeTest(){
        driver.get("http://google.com");

    }

    @After
    public void afterTest(){
        WebElement searchBox = driver.findElement(By.id("result-stats"));
        System.out.println(searchBox.getText());
        
    }

    @Test
    public void test1(){
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("elma");
        search.submit();

    }
    @Test
    public void test2(){
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("armut");
        search.submit();

    }
    @Test
    public void test3(){
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("kiraz");
        search.submit();

    }



}
