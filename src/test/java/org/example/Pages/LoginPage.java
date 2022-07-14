package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver webDriver=null;
    public LoginPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public WebElement email(){
        return webDriver.findElement(By.xpath("//*[@id=\"Email\"]"));
    }
    public WebElement password(){
        return webDriver.findElement(By.xpath("//*[@id=\"Password\"]"));
    }
    public WebElement loginButton(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }

    public void loginWith(String email,String password){
        email().sendKeys(email);
        password().sendKeys(password);
        loginButton().click();
    }

}
