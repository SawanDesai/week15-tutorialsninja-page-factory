package demo.com.tutorialsninja.testsuite;
import demo.com.tutorialsninja.customlisteners.CustomListeners;
import demo.com.tutorialsninja.pages.MyAccount;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class MyAccountTest extends BaseTest {
    MyAccount myAccount;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        myAccount = new MyAccount();
    }

    //**************************************MyAccount***************************************

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterPassword("Patel1234");
        myAccount.enterFirstName("Krish");
        myAccount.enterLastName("Desai");
        myAccount.enterEmailAdd("KrishD"+getAlphaNumericString(2)+"@gmail.com");
        myAccount.enterPhone("019235170");
        myAccount.enterPassword("Patel1234");
        myAccount.enterConfirmPass("Patel1234");
        myAccount.clickYesOnNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();
        Assert.assertEquals(myAccount.getVerifyMessage(), "Register Account", "Error Message not displayed");
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");

    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Login");
        myAccount.enterEmailAdd("KrishD@gmail.com");
        myAccount.enterPassword("Patel1234");
        myAccount.selectMyAccountOptions("Logout");
        myAccount.clickOnContinueTab();
    }
}
