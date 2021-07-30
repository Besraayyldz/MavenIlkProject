package com.techproed;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://google.com");
        String title = driver.getTitle();
//        hoogle'in title'i "Google Arama Sayfasi" ile ayni olsun
        Assert.assertEquals("Google Arama Sayfasi" , title);

        System.out.println("Test dogrulama isi bitti");

    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();

//        amazon.com un sayfa title'i amazon iceriyor
        boolean iceriyorMu = title.contains("Amazon");
        Assert.assertTrue(true);

        System.out.println("Test dogrulama isi bitti");



    }

    @Test
    public void test3(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();

//        facebook.com un sayfa title'i youtube icermiyor
        boolean iceriyorMu = title.contains("youtube");
        Assert.assertFalse(iceriyorMu);
//        test dogruysa herseyi calistirir
        System.out.println("Test dogrulama isi bitti");


    }

    @Test
    public void test4(){
        driver.get("http://google.com");
        String title = driver.getTitle();

        System.out.println("merhabalar");

        Assert.assertEquals("Google Arama Sayfasi" , title);

//        fail bir testle karsilasirsa failden sonrasini kontrol etmez
        System.out.println("Test dogrulama isi bitti");
    }





}
