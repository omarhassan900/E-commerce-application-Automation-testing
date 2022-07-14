package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {

    WebDriver webDriver=null;

    public ItemPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public WebElement addToCartButton(){
        return webDriver.findElement(By.id("add-to-cart-button-26"));
    }

    public String itemName(){
        return webDriver.findElement(By.className("product-name")).getText();
    }

    public WebElement wishlistButton(){
        return webDriver.findElement(By.id("add-to-wishlist-button-26"));
    }

}
