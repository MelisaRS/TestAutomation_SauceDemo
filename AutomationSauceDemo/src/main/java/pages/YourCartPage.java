package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourCartPage {
    WebDriver driver;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductDisplayed(String product){
        for (WebElement element: productNames) {
            if(element.getText().equalsIgnoreCase(product)){
                return true;
            }
        }
        return false;
    }

    public void removeProduct(String product){
        //sauce-labs-bike-bight
        //remove-
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "remove-"+productLowerCase;
        WebElement removeButton = driver.findElement(By.id(removeProductId));
        removeButton.click();
    }

    /////////////////////////////////
    //////// SEGUNDO PARCIAL ////////
    /////////////////////////////////

    public void clickOnCheckoutButton(){

        checkoutButton.click();
    }
}
