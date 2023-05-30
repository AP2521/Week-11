package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
  @Before
  public void setUp(){openBrowser(baseUrl);}
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        WebElement forgotPassword=driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        String actualForgotPasswordText=forgotPassword.getText();
        String expectedForgotPasswordText="Forgot your password?";
        Assert.assertEquals("Verify Forgot Password text",expectedForgotPasswordText,actualForgotPasswordText);
        forgotPassword.click();
    }
    @After
    public void tearDown(){
      closeBrowser();
    }
}
