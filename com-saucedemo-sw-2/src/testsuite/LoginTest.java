package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String url="https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(url);}
    @Test
    public void userSholdLoginSuccessfullyWithValid(){
        WebElement useName=driver.findElement(By.id("user-name"));
        useName.sendKeys("standard_user");

        WebElement passWord=driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement productsText=driver.findElement(By.xpath("//span[@class='title']"));
        String actualPrductsText=productsText.getText();
        String expextedPrductsText="Products";
        Assert.assertEquals("Verify Products Text",expextedPrductsText,actualPrductsText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        WebElement useName=driver.findElement(By.id("user-name"));
        useName.sendKeys("standard_user");

        WebElement passWord=driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement backpack=driver.findElement(By.linkText("Sauce Labs Backpack"));
        String actualBackPackText=backpack.getText();
        String expectedBackPackText="Sauce Labs Backpack";
        Assert.assertEquals("Verify BackPack Text",expectedBackPackText,actualBackPackText);

        WebElement bikeLight=driver.findElement(By.linkText("Sauce Labs Bike Light"));
        String actualbikeLightText=bikeLight.getText();
        String expectedBikeLightText="Sauce Labs Bike Light";
        Assert.assertEquals("Verify BikeLight Text",expectedBikeLightText,actualbikeLightText);

        WebElement tshirt=driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt"));
        String actualtshirtText=tshirt.getText();
        String expectedTshirtText="Sauce Labs Bolt T-Shirt";
        Assert.assertEquals("Verify T-shirt Text",expectedTshirtText,actualtshirtText);

        WebElement fleeceJacket=driver.findElement(By.linkText("Sauce Labs Fleece Jacket"));
        String actualfleeceJacketText=fleeceJacket.getText();
        String expectedfleeceJacketText="Sauce Labs Fleece Jacket";
        Assert.assertEquals("Verify fleeceJacket Text",expectedfleeceJacketText,actualfleeceJacketText);

        WebElement onesie=driver.findElement(By.linkText("Sauce Labs Onesie"));
        String actualonesieText=onesie.getText();
        String expectedonesieText="Sauce Labs Onesie";
        Assert.assertEquals("Verify onesie Text",expectedonesieText,actualonesieText);

        WebElement tshirtRed=driver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)"));
        String actualtshirtRedText=tshirtRed.getText();
        String expectedtshirtRedText="Test.allTheThings() T-Shirt (Red)";
        Assert.assertEquals("Verify tshirtRed Text",expectedtshirtRedText,actualtshirtRedText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
