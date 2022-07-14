package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver webDriver=null;

    public RegisterPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }


    public WebElement selectGrnder(String gender){

        WebElement male=webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[1]/div/span[1]/input"));
        WebElement female=webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[1]/div/span[2]/input"));

        if(gender.equals("M")){
            return male;
        }
        {
            return female;
        }
    }


    public WebElement firstName(){
        WebElement firstName= webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
        return firstName;
    }

    public WebElement lastName(){
        WebElement lastName= webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[3]/input"));
        return lastName;
    }

    public Select dayOfBirth(){
        Select selctDay=new Select(webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")));
        return selctDay;
    }

    public Select monthOfBirth(){
        Select slectMonth=new Select(webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")));
        return slectMonth;
    }

    public Select yearOfBrith(){
        Select selectYear=new Select(webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]")));
        return selectYear;
    }

    public WebElement email(){

        WebElement email=webDriver.findElement(By.xpath("//*[@id=\"Email\"]"));
        return email;
    }

    public WebElement companyName(){

        WebElement companyName=webDriver.findElement(By.xpath("//*[@id=\"Company\"]"));
        return companyName;
    }

    public WebElement password(){

        WebElement password=webDriver.findElement(By.xpath("//*[@id=\"Password\"]"));
        return password;
    }
    public WebElement confirmPassword(){
        WebElement confirmPassword=webDriver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]"));
        return confirmPassword;
    }

    public WebElement registerButton(){
        WebElement registerButton=webDriver.findElement(By.id("register-button"));
        return registerButton;
    }

    public WebElement registrationResult(){
        WebElement regitrationResult=webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
        return regitrationResult;
    }

    public void register(String gender,String firstName,String lastName,String dateOfBirth,String email,String companyName,String password ){

        selectGrnder(gender).click();
        firstName().sendKeys(firstName);
        lastName().sendKeys(lastName);
        String[] dat=dateOfBirth.split("-");
        dayOfBirth().selectByVisibleText(dat[0]);
        monthOfBirth().selectByIndex(Integer.parseInt(dat[1]));
        yearOfBrith().selectByVisibleText(dat[2]);
        email().sendKeys(email);
        companyName().sendKeys(companyName);
        password().sendKeys(password);
        confirmPassword().sendKeys(password);
        registerButton().click();
    }





}
