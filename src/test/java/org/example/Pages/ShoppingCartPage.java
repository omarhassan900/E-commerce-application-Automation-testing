package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    WebDriver  webDriver=null;

    public ShoppingCartPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }


    public List<WebElement> chartItems(){
        return webDriver.findElements(By.className("product-name"));
    }


}
