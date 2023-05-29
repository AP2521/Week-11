package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void userShouldNavigateToRegisterPageSuccessfully() {
        openBrowser(baseurl);
        WebElement registerlink=driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a"));
        String actualRegisterText=registerlink.getText();
        String expectedRegisterText="Register";
        Assert.assertEquals("Verify Register Text",expectedRegisterText,actualRegisterText);
        registerlink.click();
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        WebElement selectGender=driver.findElement(By.xpath("//div[@class='inputs']/div/span/input"));
        selectGender.click();

        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys("abc");

        WebElement lastName=driver.findElement(By.id("LastName"));
        lastName.sendKeys("efg");

        WebElement dobDay=driver.findElement(By.xpath("//div[@class='inputs date-of-birth']/div/select"));
        dobDay.sendKeys("25");

        WebElement dobMonth=driver.findElement(By.xpath("//div[@class='inputs date-of-birth']/div/select[2]"));
       dobMonth.sendKeys("10");

        WebElement dobYear=driver.findElement(By.xpath("//div[@class='inputs date-of-birth']/div/select[3]"));
        dobYear.sendKeys("1991");

        WebElement emailfield=driver.findElement(By.id("Email"));
        emailfield.sendKeys("abcde@gmail.com");

        WebElement passwordfield=driver.findElement(By.id("Password"));
        passwordfield.sendKeys("123456");

        WebElement confirmPasswordfield=driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordfield.sendKeys("123456");

        driver.findElement(By.id("register-button")).click();

        WebElement registrationComplete=driver.findElement(By.xpath("//div[@class='page registration-result-page']/div[2]/div"));
        String actualRegistrationCompleteText=registrationComplete.getText();
        String expextedRegistrationCompleteText="Your registration completed";
        Assert.assertEquals("Verify Registration Complete",expextedRegistrationCompleteText,actualRegistrationCompleteText);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}