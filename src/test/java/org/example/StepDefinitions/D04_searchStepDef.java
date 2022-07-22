package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.SearchPage;
import org.testng.Assert;

public class D04_searchStepDef {

    @When("search for any product")
    public void search_for_product(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        SearchPage searchPage=new SearchPage(Hooks.webDriver);
        homePage.searchText().sendKeys("laptop");
        homePage.searchButton().click();
    }

    @Then("products appeared successfully")
    public void product_appeared(){
        SearchPage searchPage=new SearchPage(Hooks.webDriver);
        boolean appeared;
        if(searchPage.searchResults().size()==0){
            appeared=false;
        }else appeared=true;

        Assert.assertTrue(appeared);
    }
}
