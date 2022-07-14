package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    WebDriver webDriver=null;

    public SearchPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public List<WebElement> searchResults(){
        return webDriver.findElements(By.className("product-item"));
    }


    public WebElement filterByColor(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div/div[2]/ul/li[1]/strong"));
    }
    public List<WebElement> colorOptions(){
        return webDriver.findElements(By.className("color-item"));
    }

    public WebElement randomTag(int i){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[3]/div[2]/div[1]/ul/li["+i+"]/a"));
    }

    public WebElement randomItem(int i){
        return webDriver.findElements(By.className("product-item")).get(i);
    }

    public WebElement addToCompareList(int i){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div["+i+"]/div/div[2]/div[3]/div[2]/button[2]"));
    }
}
