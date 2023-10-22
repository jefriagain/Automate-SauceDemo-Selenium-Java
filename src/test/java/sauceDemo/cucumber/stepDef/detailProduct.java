package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class detailProduct {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already login for detail" )
    public void userAlreadyLoginForDetail() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User click product item" )
    public void userClickProductItem() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();
    }

    @Then("User is on product detail" )
    public void userIsOnProductDetail() {
        String detailProductPage =driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).getText();
        Assert.assertEquals(detailProductPage, "Back to products");
        driver.close();
    }

}
