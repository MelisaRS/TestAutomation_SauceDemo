import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;

public class Checkout_YourInformationTest extends BaseTest {

    // Checkout/ Your Information/
    // Verificar que en la pagina Your Informati se puede continuar con la compra colocando valores validos
    @Test
    public void continueBuySuccessTest() {

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
        Assertions.assertTrue(checkoutOverviewPage.pageTitleOverviewIsDisplayed());
        //Thread.sleep(5000);
    }
}
