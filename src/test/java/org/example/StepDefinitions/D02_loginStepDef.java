package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D02_loginStepDef {
    @Given("navigate to login page")
    public void navigate_to_login_page(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.loginButton().click();
    }


    @Then("login done successfully")
    public void login_successfully(){
        String actualResult=Hooks.webDriver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).getText();
        String expectedResult="My account";
//        System.out.println(actualResult)c
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
