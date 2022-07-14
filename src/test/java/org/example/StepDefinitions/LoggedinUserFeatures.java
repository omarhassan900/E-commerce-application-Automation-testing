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

    @Given("navigate to login page")
    public void navigate_to_login_page(){
        HomePage homePage=new HomePage(Hooks.webDriver);
        homePage.loginButton().click();
    }
    @When("user try to login with valid user name and password")
    public void login_with_valid_username_password(){
        LoginPage loginPage=new LoginPage(Hooks.webDriver);
        loginPage.loginWith("omar122@gmail.com","123456789");
    }
    @Then("login done successfully")
    public void login_successfully(){
        String actualResult=Hooks.webDriver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).getText();
        String expectedResult="My account";
//        System.out.println(actualResult)c
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

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

    @When("select random item")
    public void select_random_item(){
        SearchPage searchPage=new SearchPage(Hooks.webDriver);
        searchPage.randomItem(2).click();
    }

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




}
