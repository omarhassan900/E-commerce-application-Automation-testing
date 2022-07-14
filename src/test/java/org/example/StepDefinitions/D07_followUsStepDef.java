package org.example.StepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.control.Tab;
import org.example.Pages.HomePage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class D07_followUsStepDef {


    @When("user click on facebook link")
    public void go_to_facebook_page(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.facebookLink().click();
    }
    @Then("navigate correctly to facebook page")
    public void navigate_to_facebook_success(){
        String expectedResult="https://www.facebook.com/nopCommerce";
        ArrayList<String> tab=new ArrayList<String>(Hooks.webDriver.getWindowHandles());
        Hooks.webDriver.switchTo().window(tab.get(1));
        String accualResult=Hooks.webDriver.getCurrentUrl();
        System.out.println(accualResult);
        Assert.assertTrue(accualResult.contains(expectedResult));
    }

    @When("user click on twitter link")
    public void go_to_twitter_page(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.twitterLink().click();
    }
    @Then("navigate correctly to twitter page")
    public void navigate_to_twitter_success(){
        String expectedResult="https://twitter.com/nopCommerce";
        ArrayList<String> tab=new ArrayList<String>(Hooks.webDriver.getWindowHandles());
        Hooks.webDriver.switchTo().window(tab.get(1));
        String accualResult=Hooks.webDriver.getCurrentUrl();
        System.out.println(accualResult);
        Assert.assertTrue(accualResult.contains(expectedResult));
    }

    @When("user click on youtube link")
    public void go_to_youtube_page(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.youtubeLink().click();
    }
    @Then("navigate correctly to youtube page")
    public void navigate_to_youtube_success(){
        String expectedResult="https://www.youtube.com/user/nopCommerce";
        ArrayList<String> tab=new ArrayList<String>(Hooks.webDriver.getWindowHandles());
        Hooks.webDriver.switchTo().window(tab.get(1));
        String accualResult=Hooks.webDriver.getCurrentUrl();
        System.out.println(accualResult);
        Assert.assertTrue(accualResult.contains(expectedResult));
    }

    @When("user click on rss link")
    public void go_to_rss_page(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.rssLink().click();
    }

    @Then("navigate correctly to rss page")
    public void navigate_to_rss_success(){
        String expectedResult="https://demo.nopcommerce.com/new-online-store-is-open";
        ArrayList<String> tab=new ArrayList<String>(Hooks.webDriver.getWindowHandles());
        Hooks.webDriver.switchTo().window(tab.get(1));
        String accualResult=Hooks.webDriver.getCurrentUrl();
        System.out.println(accualResult);
        Assert.assertTrue(accualResult.contains(expectedResult));
    }
}
