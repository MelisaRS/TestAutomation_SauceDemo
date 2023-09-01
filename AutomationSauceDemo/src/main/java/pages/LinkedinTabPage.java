package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LinkedinTabPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@data-tracking-control-name = 'organization_guest_contextual-sign-in-modal_modal_dismiss']")
    WebElement closeFloatWindow;

    @FindBy(xpath = "//li-icon[@type = 'app-linkedin-bug-color-icon']")
    WebElement iconLinkedin;

    @FindBy(className = "org-top-card-summary__tagline")
    WebElement detailsSauceLabsLinkedin;

    /*
    @FindBy(xpath = "//span[@dir = 'ltr']")
    WebElement sauceLabsLinkedin;
     */

    public LinkedinTabPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCloseFloatWindow() {
        closeFloatWindow.click();
    }

    public boolean isNameSauceLabsLinkedinDisplayed(String nameSauceLabs){
        List<WebElement> sauceLabsLinkedin = driver.findElements(By.xpath("//span[@dir = 'ltr']"));

        for (WebElement element: sauceLabsLinkedin)
        {
            if(element.getText().equalsIgnoreCase(nameSauceLabs)){
                return true;
            }
        }
        return false;
    }

    public boolean isDetailsSauceLabsLinkedinDisplayed(String detailsSauceLabs){

        if(detailsSauceLabsLinkedin.getText().equalsIgnoreCase(detailsSauceLabs)){
            return true;
        }
        return false;
    }

    public boolean isIconLinkedinDisplayed() {
        boolean iconPageLinkedin = iconLinkedin.isDisplayed();
        return iconPageLinkedin;
    }

    public boolean isDetailsSauceLabsDisplayed() {
        boolean isDetails = detailsSauceLabsLinkedin.isDisplayed();
        return isDetails;
    }
}