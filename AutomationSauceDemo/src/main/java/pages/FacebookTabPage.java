package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookTabPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@aria-label = 'Cerrar']")
    WebElement buttonFloatClose;

    @FindBy(className = "xe3v8dz")
    WebElement iconFacebook;

    public FacebookTabPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCloseFloatWindow(){
        buttonFloatClose.click();
    }

    public boolean isUrlFacebookCorrect(String urlFacebookSauceLabs){
        String facebookTab = driver.getCurrentUrl();
        if(facebookTab.equalsIgnoreCase(urlFacebookSauceLabs)){
            return true;
        }
        return false;
    }

    public boolean isIconFacebookDisplayed(){
        boolean iconPageFacebook = iconFacebook.isDisplayed();
        return iconPageFacebook;
    }

}
