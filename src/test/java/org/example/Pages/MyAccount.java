package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {

    WebDriver webDriver=null;
    public MyAccount(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public WebElement changePassword(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a"));
    }

    public WebElement oldPassword(){
        return webDriver.findElement(By.id("OldPassword"));
    }
    public WebElement newPassword(){
        return webDriver.findElement(By.id("NewPassword"));
    }
    public WebElement confirmPassword(){
        return webDriver.findElement(By.id("ConfirmNewPassword"));
    }

    public WebElement changePasswordButton(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button"));
    }


    public void resetPassword(String oldPassword,String newPassword){
        oldPassword().sendKeys(oldPassword);
        newPassword().sendKeys(newPassword);
        confirmPassword().sendKeys(newPassword);
    }
}
