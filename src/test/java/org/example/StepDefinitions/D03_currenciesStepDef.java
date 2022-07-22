package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.Assert;

public class D03_currenciesStepDef {

    @When("user try to login with valid user name and password")
    public void login_with_valid_username_password(){
        LoginPage loginPage=new LoginPage(Hooks.webDriver);
        loginPage.loginWith("omar122@gmail.com","123456789");
    }

    @When("change the currency")
    public void change_currency(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.currencySelector().selectByIndex(1);
    }

    @Then("currency changed successfully")
    public void current_currency_is_euro(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        String actualResult= homePage.currentCurrency().getText();
        System.out.println(actualResult);
        String expectedResult="€";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
