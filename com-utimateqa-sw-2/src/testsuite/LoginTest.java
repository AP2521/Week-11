package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        WebElement welcomeback=driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actuatWelcomeBackText=welcomeback.getText();
        String expectedWelcomeBackText="Welcome Back!";
        Assert.assertEquals("Verify WelcomeBack Text",expectedWelcomeBackText,actuatWelcomeBackText);
    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        WebElement emailField=driver.findElement(By.id("user[email]"));
        emailField.sendKeys("abc@yahoo.com");

        WebElement passWord=driver.findElement(By.id("user[password]"));
        passWord.sendKeys("12345");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage=driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualErrorMessageText=errorMessage.getText();
        String expectedErrorMessageText="Invalid email or password.";
        Assert.assertEquals("Verify Error Message",expectedErrorMessageText,actualErrorMessageText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
