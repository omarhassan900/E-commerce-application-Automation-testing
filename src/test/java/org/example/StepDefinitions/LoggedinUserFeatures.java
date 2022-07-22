package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoggedinUserFeatures {

//    WebDriver webDriver=null;
//    @Given("user open the application home page")
//    public void open_home_page(){
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\main\\resources\\chromedriver.exe");
//        webDriver=new ChromeDriver();
//        webDriver.navigate().to("https://demo.nopcommerce.com/");
//        webDriver.manage().window().maximize();
//    }



    @When("select apparel category")
    public void select_apparel_category(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.category(3).click();
    }
    @When("select shoese sub category")
    public void select_shoes_from_apparel(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.subCategory(1).click();
    }
    @Then("filter by color appeared")
    public void filter_by_color_appeared(){
        SearchPage searchPage=new SearchPage(Hooks.webDriver);
        String acctualResult=searchPage.filterByColor().getText();
        System.out.println(acctualResult);
        String expectedResult="Color";
        Assert.assertTrue(acctualResult.contains(expectedResult));

    }

    @Then("different color options appeared")
    public void color_options_appeared(){
        SearchPage searchPage= new SearchPage(Hooks.webDriver);
        int numberOfColors=searchPage.colorOptions().size();
        boolean appeared= numberOfColors !=0;
        Assert.assertTrue(appeared);
    }
    @When("select random tag")
    public void select_random_tag(){
        SearchPage searchPage=new SearchPage(Hooks.webDriver);
        searchPage.randomTag(3).click();
    }
    @Then("tag selected successfully")
    public void tag_selected_success(){
        int numberOfItems= Hooks.webDriver.findElements(By.className("product-item")).size();
        System.out.println(numberOfItems);
        boolean noItemsAppeared=numberOfItems==0;
        Assert.assertFalse(noItemsAppeared);
    }







    @When("add item ti compare list")
    public void add_item_to_compare_list(){
        SearchPage searchPage=new SearchPage(Hooks.webDriver);
        searchPage.addToCompareList(1).click();
    }
    @Then("item is added successfully to compare list")
    public void item_added_success_to_compare_list(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        String expectedResult="The product has been added to your product comparison";
        String acctualResult=homePage.notificationBarText();
        Assert.assertTrue(acctualResult.contains(expectedResult));
    }









    @When("go to my account")
    public void navigate_to_myaccount(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.myAccountButton().click();
    }
    @When("press change password")
    public void navigate_to_change_password(){
        MyAccount myAccount=new MyAccount(Hooks.webDriver);
        myAccount.changePassword().click();

    }
    @When("enter old and new password")
    public void enter_old_new_password(){
        MyAccount myAccount=new MyAccount(Hooks.webDriver);
        myAccount.resetPassword("123123123123","1234567890088");
        myAccount.changePasswordButton().click();
    }

    @Then("password changed successfully")
    public void password_changed_success(){
        boolean passwordIsChanged;
        try {
            Hooks.webDriver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
            passwordIsChanged=true;
        }catch (NoSuchElementException e){
            passwordIsChanged=false;
        }
        Assert.assertTrue(passwordIsChanged);
    }











}
