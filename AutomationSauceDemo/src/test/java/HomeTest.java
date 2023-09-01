import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class HomeTest extends BaseTest{

    @Test
    public void orderingFromZToA() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Name (Z to A)");
        Assertions.assertTrue(homePage.areProductsInDescendantOrderByName());

        Thread.sleep(5000);

    }

    //Ejercicios de ordenamiento extras pedidos por el docente
    @Test
    public void orderingFromAToZ() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Name (A to Z)");
        Assertions.assertTrue(homePage.areProductsInAscendantOrderByName());

        Thread.sleep(5000);

    }

    @Test
    public void orderingFromLowToHigh() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Price (low to high)");
        Assertions.assertTrue(homePage.areProductsInAscendantOrderByPrice());

        Thread.sleep(5000);

    }

    @Test
    public void orderingFromHighToLow() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Price (high to low)");
        Assertions.assertTrue(homePage.areProductsInDescendantOrderByPrice());

        Thread.sleep(5000);
    }

    @Test
    public void verifyLinkFooterLinkedin(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnLinkedinFooter();

    }
}
