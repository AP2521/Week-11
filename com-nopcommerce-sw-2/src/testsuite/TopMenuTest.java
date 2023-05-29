package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
String baseurl="https://demo.nopcommerce.com/";
    @Before
            public void userIsInLoginPage(){
        openBrowser(baseurl);
        WebElement loginLink=driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("qw@gmail.com");

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("123456");

        WebElement login=driver.findElement(By.xpath("//div[@class='returning-wrapper fieldset']/form/div[3]/button"));
        login.click();

    }


    @Test
         public void userShouldNavigateToComputerPageSuccessfully(){
            WebElement computerTab = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li/a"));
            String actualComputerText = computerTab.getText();
            String expectedComputerText = "Computers";
            Assert.assertEquals("Verify computer text", expectedComputerText, actualComputerText);
            computerTab.click();
        }
    @Test
        public void userShouldNavigateToElectronicsPageSuccessfully(){
            WebElement electronicsTab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));
            String actualElectronicsText=electronicsTab.getText();
            String expectedElectronicsText="Electronics";
            Assert.assertEquals("Verify Electronics Tab",expectedElectronicsText,actualElectronicsText);
            electronicsTab.click();
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
            WebElement apparelTab=driver.findElement(By.xpath("//a[contains(text(),'Apparel')]"));
            String actualApparelText=apparelTab.getText();
            String expectedApparelText="Apparel";
            Assert.assertEquals("Verify Apparel Text",expectedApparelText,actualApparelText);
            apparelTab.click();
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        WebElement digitalDownloadsTab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[4]/a"));
        String actualDigitalText=digitalDownloadsTab.getText();
        String expectedDigitalText="Digital downloads";
        Assert.assertEquals("Verify Digital Text",expectedDigitalText,actualDigitalText);
        digitalDownloadsTab.click();
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        WebElement booksTab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[5]/a"));
        String actualBooksText=booksTab.getText();
        String expectedBooksText="Books";
        Assert.assertEquals("Verify books text",expectedBooksText, actualBooksText);
        booksTab.click();
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        WebElement jewelryTab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[6]/a"));
        String actualJewelryText=jewelryTab.getText();
        String expectedJewelryText="Jewelry";
        Assert.assertEquals("Verify jewelry text",expectedJewelryText,actualJewelryText);
        jewelryTab.click();
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        WebElement giftCardsTab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[7]/a"));
        String actualGiftCardsText=giftCardsTab.getText();
        String expectedGiftCardText="Gift Cards";
        Assert.assertEquals("Verify Gift Cards Text",expectedGiftCardText,actualGiftCardsText);
        giftCardsTab.click();
    }

    @After
    public void teardown(){
        closeBrowser();
    }
    }
