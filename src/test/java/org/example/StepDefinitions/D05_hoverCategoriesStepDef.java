package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {

    @When("select random category")
    public void select_random_category(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.category(3).click();
    }

    @When("select sub category")
    public void select_random_sub_category(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.subCategory(1).click();
    }

    @Then("category selection done successfully")
    public void category_selection_success(){
        int numberOfItems= Hooks.webDriver.findElements(By.className("product-item")).size();
        System.out.println(numberOfItems);
        boolean noItemsAppeared=numberOfItems==0;
        Assert.assertFalse(noItemsAppeared);
    }
}
