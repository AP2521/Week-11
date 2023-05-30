package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
String baseUrl="http://the-internet.herokuapp.com/login";
@Before
    public void setUp(){
openBrowser(baseUrl);}
@Test
     public void userSholdLoginSuccessfullyWithValidCredentials(){
    WebElement userName=driver.findElement(By.id("username"));
    userName.sendKeys("tomsmith");

    WebElement password=driver.findElement(By.id("password"));
    password.sendKeys("SuperSecretPassword!");

    WebElement loginButton=driver.findElement(By.xpath("//button[@class='radius']"));
    loginButton.click();

    WebElement secureArea=driver.findElement(By.xpath("//div[@class='example']/h2[text()=' Secure Area']"));
    String actualsecureAreaText=secureArea.getText();
    String expectedSecureAreaText="Secure Area";
    Assert.assertEquals("Verify Secure Area Text",expectedSecureAreaText,actualsecureAreaText); }

@Test
   public void verifyTheUsernameErrorMessage(){
    WebElement userName=driver.findElement(By.id("username"));
    userName.sendKeys("tomsmith1");

    WebElement password=driver.findElement(By.id("password"));
    password.sendKeys("SuperSecretPassword!");

    WebElement loginButton=driver.findElement(By.xpath("//button[@class='radius']"));
    loginButton.click();

    WebElement errorMessage=driver.findElement(By.id("flash"));
    String actualErrorMessageText=errorMessage.getText();
    String expectedErrorMessageText="Your username is invalid!\n" +"×";
    Assert.assertEquals("Verify Secure Area Text",expectedErrorMessageText,actualErrorMessageText); }
@Test
    public void verifyThePasswordErrorMessage(){
    WebElement userName=driver.findElement(By.id("username"));
    userName.sendKeys("tomsmith");

    WebElement password=driver.findElement(By.id("password"));
    password.sendKeys("SuperSecretPassword");

    WebElement loginButton=driver.findElement(By.xpath("//button[@class='radius']"));
    loginButton.click();

    WebElement errorMessage=driver.findElement(By.id("flash"));
    String actualErrorMessageText=errorMessage.getText();
    String expectedErrorMessageText="Your password is invalid!\n" +"×";
    Assert.assertEquals("Verify Secure Area Text",expectedErrorMessageText,actualErrorMessageText); }
@After
    public void tearDown(){
    closeBrowser();
    }
}
