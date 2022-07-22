package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.RegisterPage;
import org.testng.Assert;

public class D01_registerStepDef {
    @When("user navigate to registration page")
    public void navigate_to_registration_page(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.registerButton().click();
    }
    @When("enter a valid registration data")
    public void register_with_valid_data(){
        RegisterPage registerPage=new RegisterPage(Hooks.webDriver);
        registerPage.register("M","Omar","Hassan","1-7-1990","omar122@gmail.com","orange","123456789");
    }
    @Then("registration done successfully")
    public void registration_success(){
        RegisterPage registerPage=new RegisterPage(Hooks.webDriver);
        String expectedResult="Your registration completed";
        String actualResult=registerPage.registrationResult().getText();
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
