package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Login page sauceDemo" )
    public void login_page_sauceDemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String loginPageAssert =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

    }

    @When("User input username" )
    public void user_input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input password" )
    public void user_input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button" )
    public void click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User is on home page" )
    public void user_is_on_home_page() {
        driver.findElement(By.xpath("//*[contains(text(), 'Swag Labs')]"));
        String title = driver.findElement(By.xpath("//*[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(title, "Products");
        driver.close();
    }

    @And("User input invalid password" )
    public void user_input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("Password1!");
    }

    @Then("User get error message" )
    public void user_get_error_message() {
        String errorLogin = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
