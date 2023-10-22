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

public class addToCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User already login" )
    public void userAlreadyLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User click add to cart button" )
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("Product added to cart" )
    public void productAddedToCart() {
        String cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span" )).getText();
        Assert.assertNotEquals(cart, "0" );
        driver.close();
    }


}
