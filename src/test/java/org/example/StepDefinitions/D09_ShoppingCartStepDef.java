package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.ItemPage;
import org.example.Pages.ShoppingCartPage;
import org.testng.Assert;

public class D09_ShoppingCartStepDef {


    @When("add item to chart")
    public void press_add_to_chart(){
        ItemPage itemPage=new ItemPage(Hooks.webDriver);
        itemPage.addToCartButton().click();
    }

    @Then("item is added successfully")
    public void item_added_success(){
        ItemPage itemPage=new ItemPage(Hooks.webDriver);
        HomePage homePage=new HomePage(Hooks.webDriver);
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage(Hooks.webDriver);
        String expectedResult= itemPage.itemName();
        homePage.shoppingCartButton().click();
        boolean itemIsAdded=false;
        for (int i=0;i<shoppingCartPage.chartItems().size();i++){
            if (shoppingCartPage.chartItems().get(i).getText().contains(expectedResult)){
                itemIsAdded=true;
                break;
            }
        }
        Assert.assertTrue(itemIsAdded);


    }
}
