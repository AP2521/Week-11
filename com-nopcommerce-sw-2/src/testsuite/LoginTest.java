package testsuite;


import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl="https://demo.nopcommerce.com/";
    @Before
    public void setUp(){openBrowser(baseurl);}

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        WebElement loginLink=driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement welcomeMessage=driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage= welcomeMessage.getText();
        String expectedMessage="Welcome, Please Sign In!";
        Assert.assertEquals("Verify Message",expectedMessage,actualMessage);}
@Test
        public void userShouldLoginSuccessfullyWithValidCredentials(){
            WebElement loginLink=driver.findElement(By.className("ico-login"));
            loginLink.click();

            WebElement email = driver.findElement(By.id("Email"));
            email.sendKeys("qw@gmail.com");

            WebElement passWord = driver.findElement(By.id("Password"));
            passWord.sendKeys("123456");

            WebElement login=driver.findElement(By.xpath("//div[@class='returning-wrapper fieldset']/form/div[3]/button"));
             login.click();

             WebElement logout=driver.findElement(By.linkText("Log out"));
             String actualLogoutButton=logout.getText();
             String expectedLogoutButton="Log out";
             Assert.assertEquals("Verify Logout Button",expectedLogoutButton,actualLogoutButton);}
 @Test
    public void verifyTheErrorMessage(){
     WebElement loginLink=driver.findElement(By.className("ico-login"));
     loginLink.click();

     WebElement email = driver.findElement(By.id("Email"));
     email.sendKeys("bc@yahoo.com");

     WebElement passWord = driver.findElement(By.id("Password"));
     passWord.sendKeys("23456");

     WebElement login=driver.findElement(By.xpath("//div[@class='returning-wrapper fieldset']/form/div[3]/button"));
     login.click();

     WebElement  verifyErrorMessage=driver.findElement(By.xpath("//form[@method='post']/div"));
     String actualErrorMessage=verifyErrorMessage.getText();
     String expectedErrorMessage="Login was unsuccessful. Please correct the errors and try again.\n"
             +"No customer account found";
     Assert.assertEquals("Verify Error Message",expectedErrorMessage,actualErrorMessage);

        }
        @After
        public void tearDown(){
       closeBrowser();
        }
    }

