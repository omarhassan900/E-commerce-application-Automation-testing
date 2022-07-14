package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishlistPage {
    WebDriver webDriver=null;

    public WishlistPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public List<WebElement> wishlistItems(){
        return webDriver.findElements(By.className("product-name"));
    }
}
