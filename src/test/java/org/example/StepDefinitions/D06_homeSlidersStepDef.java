package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef {

    @When("user first select slider")
    public void select_first_slider(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.sliderChooser(1);
    }

    @Then("user get navigated to first item url")
    public void url_changedf_success(){
        String expectedResult="https://demo.nopcommerce.com/nokia-lumia-1020";
        String accualResult=Hooks.webDriver.getCurrentUrl();
        Assert.assertTrue(accualResult.contains(expectedResult));
    }

    @When("user second select slider")
    public void select_second_slider(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.sliderChooser(2);
    }
    @Then("user get navigated to item url")
    public void url_changeds_success(){
        String expectedResult="https://demo.nopcommerce.com/iphone-6";
        String accualResult=Hooks.webDriver.getCurrentUrl();
        Assert.assertTrue(accualResult.contains(expectedResult));
    }

}


