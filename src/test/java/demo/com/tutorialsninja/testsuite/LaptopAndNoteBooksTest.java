package demo.com.tutorialsninja.testsuite;
import demo.com.tutorialsninja.customlisteners.CustomListeners;
import demo.com.tutorialsninja.pages.Desktop;
import demo.com.tutorialsninja.pages.LaptopAndNotebooks;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class LaptopAndNoteBooksTest extends BaseTest {
        Desktop desktops;
        LaptopAndNotebooks laptopsAndNotebooks;


    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        desktops = new Desktop();
        laptopsAndNotebooks = new LaptopAndNotebooks();
          }

    //*************************************LaptopsAndNotebooks*************************************************
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully () {

        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully () throws InterruptedException {
        desktops.clickOnCurrecyLink();
        laptopsAndNotebooks.changeCurrency();

        Thread.sleep(2000);
        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();
        laptopsAndNotebooks.clickOnMacbookLink();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
        laptopsAndNotebooks.clickOnAddToCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopsAndNotebooks.clickOnShoppingCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), " ");
        laptopsAndNotebooks.clickOnUpdateCart();
        Thread.sleep(2000);
        //Assert.assertEquals(laptopsAndNotebooks.getVerifyCartText(), "Success: You have added MacBook to your shopping cart!\n" +
        //       "×", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyTotal(), "2 item(s) - £737.45", "Error Message not displayed");

        laptopsAndNotebooks.clickOnCheckoutCart();
        laptopsAndNotebooks.clickOnFinalCheckout();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        //Assert.assertEquals(laptopsAndNotebooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");

        laptopsAndNotebooks.clickOnGuestCheckout();
        laptopsAndNotebooks.clickOnContinueTab();
        Thread.sleep(2000);
        laptopsAndNotebooks.enterName("Krish");
        laptopsAndNotebooks.enterLastName("Desai");
        laptopsAndNotebooks.enterTelephone("01923517070");
        laptopsAndNotebooks.enterAddress("20Tudorwalk");
        laptopsAndNotebooks.enterCity("Watford");
        laptopsAndNotebooks.enterPostcode("WD24 7PA");
        laptopsAndNotebooks.enterCountry("UK");
        laptopsAndNotebooks.enterState("London");

        laptopsAndNotebooks.clickOnCheckout();
        laptopsAndNotebooks.enterText("Please Update Delivery date.");

        laptopsAndNotebooks.clickOnTerms();
        laptopsAndNotebooks.clickContinue();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }

}
