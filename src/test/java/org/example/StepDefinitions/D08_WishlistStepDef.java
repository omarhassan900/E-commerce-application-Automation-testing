package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.ItemPage;
import org.example.Pages.SearchPage;
import org.example.Pages.WishlistPage;
import org.testng.Assert;

public class D08_WishlistStepDef {

    @When("select random item")
    public void select_random_item(){
        SearchPage searchPage=new SearchPage(Hooks.webDriver);
        searchPage.randomItem(2).click();
    }

    @When("press add to wishlist button")
    public void add_to_wishlist(){
        ItemPage itemPage=new ItemPage(Hooks.webDriver);
        itemPage.wishlistButton().click();
    }

    @Then("item is added successfully to the wishlist")
    public void item_added_success_to_wishlist(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        WishlistPage wishlistPage=new WishlistPage(Hooks.webDriver);
        ItemPage itemPage=new ItemPage(Hooks.webDriver);


        String expectedResult= itemPage.itemName();
        homePage.wishlistButton().click();
        boolean added=false;
        for (int i=0;i<wishlistPage.wishlistItems().size();i++){
            if(wishlistPage.wishlistItems().get(i).getText().contains(expectedResult)){
                added=true;
                break;
            }
        }

        Assert.assertTrue(added);

    }


}
