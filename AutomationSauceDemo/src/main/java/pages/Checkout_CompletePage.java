package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_CompletePage {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement pageTitleComplete;

    @FindBy(className = "complete-header")
    WebElement messageComplete;

    @FindBy(name = "back-to-products")
    WebElement backHomeButton;

    public Checkout_CompletePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean pageTitleCompleteIsDisplayed(){
        boolean pageTitleCompleteDisplayed = pageTitleComplete.isDisplayed();
        return pageTitleCompleteDisplayed ;
    }

    public boolean isMessageDisplayed(String message){
        if(messageComplete.getText().equalsIgnoreCase(message)){
            return true;
        }
        return false;
    }

    public boolean isBackHomeButtonIsDisplayed(){
        boolean pageBackHomeButton = backHomeButton.isDisplayed();
        return pageBackHomeButton;
    }

    public void clickOnBackHomeButton(){
        backHomeButton.click();
    }
}
