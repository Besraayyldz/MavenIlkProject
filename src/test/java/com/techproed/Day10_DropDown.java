package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

      /*
      Select classindan nesne uretmeden dropDown uzerinde islem yapamayiz.
      eger dropDown ile ilgili mulakat sorusu gelirse kesinlikle select clasindan bahsetmeniz gerekir

       */
        Select select = new Select(dropDown);

//        secenegin yazisina gore secebiliriz
        select.selectByVisibleText("Beauty & Personal Care");//Beauty & Personal Care'i seciyor

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //secenegin valeu attribute kullanarak secebiliriz

        select.selectByValue("search-alias=fashion-girls-intl-ship");//girls fashionu seciyor
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByIndex(0);//all departmans'i seciyor
        //secenegin bulundugu siraya gore secebilirsin
//        indexi 0 olani bulur

//        getFirstSelectedOption() - dropDown uzerinde secili olan web elemwnti return eder
        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());

//        getOptions() - tum seecimleri List<WebElement> seklinde return eder
        List<WebElement> liste = select.getOptions();
        for (WebElement w : liste){
            System.out.println(w.getText());
        }
//        liste.size() - tum seceneklerin toplam sayisini retrn eder
        int toplamSenenekSayisi = liste.size();
        System.out.println("Toplam secenek sayisi = "+toplamSenenekSayisi);


    }





}
