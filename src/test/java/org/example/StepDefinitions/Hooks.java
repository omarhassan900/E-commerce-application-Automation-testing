package org.example.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;

public class Hooks {


    public static WebDriver webDriver=null;
    @Before
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\main\\resources\\chromedriver.exe");
        webDriver=new ChromeDriver();
        webDriver.navigate().to("https://demo.nopcommerce.com/");
        webDriver.manage().window().maximize();
    }

    @After
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }
}
