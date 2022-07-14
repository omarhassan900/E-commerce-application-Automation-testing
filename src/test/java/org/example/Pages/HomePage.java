package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {



    WebDriver webDriver=null;

    public HomePage(WebDriver webDriver){

        this.webDriver=webDriver;
    }


    public WebElement registerButton(){

        WebElement registerButton= webDriver.findElement(By.className("ico-register"));
        return registerButton;
    }

    public WebElement loginButton(){
        WebElement loginButton=webDriver.findElement(By.className("ico-login"));
        return loginButton;
    }
    public WebElement myAccountButton(){
        return webDriver.findElement(By.className("ico-account"));
    }

    public WebElement searchText(){

        return webDriver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchButton(){
        return webDriver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }
    public Select currencySelector(){
        return new Select(webDriver.findElement(By.id("customerCurrency")));
    }

    public WebElement currentCurrency(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]/span"));
    }

    public WebElement category(int i){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li["+i+"]/a"));
    }

    public WebElement subCategory(int i){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[3]/ul/li["+i+"]/a"));
    }

    public WebElement shoppingCartButton(){
        return webDriver.findElement(By.className("ico-cart"));
    }


    public WebElement  wishlistButton(){
        return webDriver.findElement(By.className("ico-wishlist"));
    }


    public String notificationBarText(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return webDriver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
    }


    public WebElement sliderChooser(int i){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a["+i+"]"));
    }


    public WebElement facebookLink(){
        return webDriver.findElement(By.className("facebook"));
    }

    public WebElement twitterLink(){
        return webDriver.findElement(By.className("twitter"));
    }
    public WebElement youtubeLink(){
        return webDriver.findElement(By.className("youtube"));
    }

    public WebElement rssLink(){
        return webDriver.findElement(By.className("rss"));
    }







}
