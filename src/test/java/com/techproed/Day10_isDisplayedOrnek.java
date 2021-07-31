package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class Day10_isDisplayedOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.bestbuy.com/");

    }

    @After
    public void afterTest(){
        driver.quit();

    }
//    sayfa title Best iceriyor mu
    @Test
    public void titleTest(){
        String title = driver.getTitle();
        boolean bestIceriyorMu = title.contains("Best");
        Assert.assertTrue(bestIceriyorMu);

    }
//    logo test bestbuy logosunun goruntulenip goruntulenmedigini dogrula
    @Test
    public void logoTest(){
        WebElement logoTest = driver.findElement(By.xpath("//img[@class='logo']"));
        boolean logoGorunurMu = logoTest.isDisplayed();
        Assert.assertTrue(logoGorunurMu);

    }

    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLink = driver.findElement(By.partialLinkText("Mexico"));
        boolean linkGorunuyorMu = mexicoLink.isDisplayed();
        Assert.assertTrue(linkGorunuyorMu);
    }

}
