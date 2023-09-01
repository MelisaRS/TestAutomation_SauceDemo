import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import utilities.DriverManager;

public class ProductDetailsTest extends BaseTest {

    // Products/
    // Verificar que la pagina de products muestra toda la informacion del producto al hacer clic en el

    @Test
    public void verifyInformationProductDetails() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);

        homePage.clickOnProductDetails("Sauce Labs Bike Light");

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(DriverManager.getDriver().driver);

        Assertions.assertTrue(productDetailsPage.isProductNameDisplayed("Sauce Labs Bike Light"));
        Assertions.assertTrue(productDetailsPage.imageProductIsDisplayed());
        Assertions.assertTrue(productDetailsPage.detailsProductIsDisplayed());
        Assertions.assertTrue(productDetailsPage.isProductPriceDisplayed("$9.99"));
        productDetailsPage.clickOnAddToCartButton();
        Assertions.assertTrue(productDetailsPage.isEqualNumberShoppingCartWithNumberProduct("1"));

        Thread.sleep(5000);

    }
}
