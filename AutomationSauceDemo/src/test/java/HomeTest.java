import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FacebookTabPage;
import pages.HomePage;
import pages.LinkedinTabPage;
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
    public void verifyLinkFooterLinkedin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        //Thread.sleep(5000);
        //homePage.clickOnLinkedinFooter();
        //homePage.clickOnFacebookFooter();
        homePage.clickOnFootterAndchangeTabFacebook();
        //homePage.changeTabLinkedin();

        //LinkedinTabPage linkedinTabPage = new LinkedinTabPage(DriverManager.getDriver().driver);
        FacebookTabPage facebookTabPage = new FacebookTabPage(DriverManager.getDriver().driver);
        //Thread.sleep(5000);
        facebookTabPage.clickOnCloseFloatWindow();

        Assertions.assertTrue(facebookTabPage.isUrlFacebookCorrect("https://www.facebook.com/saucelabs"));
        //Thread.sleep(5000);
        homePage.changeTabSauceDemo();

        //Assertions.assertTrue(facebookTabPage.isIconFacebookDisplayed());


        //linkedinTabPage.clickOnCloseFloatWindow();
        //Assertions.assertTrue(linkedinTabPage.isNameSauceLabsLinkedinDisplayed("Sauce Labs"));
        //Assertions.assertTrue(linkedinTabPage.isDetailsSauceLabsLinkedinDisplayed("Sauce Labs helps enterprises ensure your favorite apps and websites work flawlessly on every browser, OS, and device."));
        //Assertions.assertTrue(linkedinTabPage.isIconLinkedinDisplayed());
        //Assertions.assertTrue(linkedinTabPage.isDetailsSauceLabsDisplayed());
        //LinkedinTabPage.cleanUpLinkedin();
        //Thread.sleep(5000);

    }
}
