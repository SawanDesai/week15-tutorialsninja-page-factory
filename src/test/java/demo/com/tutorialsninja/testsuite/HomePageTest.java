package demo.com.tutorialsninja.testsuite;
import demo.com.tutorialsninja.customlisteners.CustomListeners;
import demo.com.tutorialsninja.pages.Desktop;
import demo.com.tutorialsninja.pages.Homepage;
import demo.com.tutorialsninja.pages.LaptopAndNotebooks;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {

  Homepage homePage;
  Desktop desktops;
  LaptopAndNotebooks laptopsAndNotebooks;

    ///Homepage
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
   homePage = new Homepage();
   desktops = new Desktop();
   laptopsAndNotebooks = new LaptopAndNotebooks();

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnDesktopLink();
        homePage.selectMenu("Show All Desktops");
        // String expectedMessage = "Desktops";
        Assert.assertEquals(homePage.getVerifyText(), "Desktops", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.clickOnLaptopNotebooksLink();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedMessage = "Laptops & Notebooks";
        Assert.assertEquals(homePage.getVerifyText1(), expectedMessage, "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.clickOnComponentsLink();
        homePage.selectMenu("Show All Components");
        String expectedMessage = "Components";
        Assert.assertEquals(homePage.getVerifyText2(), expectedMessage, "Error Message not displayed");

    }

}
