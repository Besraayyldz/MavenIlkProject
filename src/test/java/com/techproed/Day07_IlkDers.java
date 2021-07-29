package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.ws.WebEndpoint;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get("http://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("samsung headphones"+ Keys.ENTER);

        WebElement resultFor = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(resultFor.getText());

        WebElement ilkSecim = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(ilkSecim.getText());

        List<WebElement> listem = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for(WebElement w:listem){
            System.out.println(w.getText());
        }
    }
}
