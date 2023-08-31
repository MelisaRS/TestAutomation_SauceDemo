import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;

public class Checkout_CompleteTest extends BaseTest {
    @Test
    public void verifyBuySuccessful() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        yourCartPage.clickOnCheckoutButton();

        Checkout_YourInformationPage checkoutYourInformationPage = new Checkout_YourInformationPage(DriverManager.getDriver().driver);

        checkoutYourInformationPage.setFirstNameTextBox("Melisa");
        checkoutYourInformationPage.setLastNameTextBox("Rojas");
        checkoutYourInformationPage.setZipCodeTextBox("0000");
        checkoutYourInformationPage.clickOnContinueButton();

        Checkout_OverviewPage checkoutOverviewPage = new Checkout_OverviewPage(DriverManager.getDriver().driver);

        checkoutOverviewPage.clickOnFinishButton();

        Checkout_CompletePage checkoutCompletePage = new Checkout_CompletePage(DriverManager.getDriver().driver);

        Assertions.assertTrue(checkoutCompletePage.pageTitleCompleteIsDisplayed());
        Assertions.assertTrue(checkoutCompletePage.isMessageDisplayed("Thank you for your order!"));
        Assertions.assertTrue(checkoutCompletePage.isBackHomeButtonIsDisplayed());

        checkoutCompletePage.clickOnBackHomeButton();
        Assertions.assertTrue(homePage.isProductTitleDisplayed("Products"));

        Thread.sleep(5000);

    }
}
