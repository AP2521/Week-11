package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
@Before
    public void setUp(){openBrowser(baseUrl);}
@Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
    WebElement userNameField=driver.findElement(By.xpath("//div[@class='oxd-form-row']/div/div[2]/input"));
    userNameField.sendKeys("Admin");

    WebElement passwordField=driver.findElement(By.xpath("//input[@name='password']"));
    passwordField.sendKeys("admin123");

    WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
    login.click();

    WebElement dashboard=driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
    String actualDashboardText=dashboard.getText();
    String expectedDashboardText="Dashboard";
    Assert.assertEquals("Verify Dashboard Text",expectedDashboardText,actualDashboardText);}

    @After
    public void tearDown(){
    closeBrowser();
    }
}
