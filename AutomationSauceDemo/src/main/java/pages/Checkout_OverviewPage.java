package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Checkout_OverviewPage {

    WebDriver driver;

    @FindBy(className = "title")
    WebElement pageTitleOverview;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(id = "finish")
    WebElement finishButton;

    public Checkout_OverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean pageTitleOverviewIsDisplayed(){
        boolean pageTitleOverviewDisplayed = pageTitleOverview.isDisplayed();
        return pageTitleOverviewDisplayed ;
    }

    public boolean isProductDisplayed(String product){
        for (WebElement element: productNames) {
            if(element.getText().equalsIgnoreCase(product)){
                return true;
            }
        }
        return false;
    }

    // Función para obtener el valor numérico de un precio en formato "$ X.XX"
    private double getNumericPrice(String price) {

        return Double.parseDouble(price.replace("$", ""));
    }

    private double getNumericPriceTotal(String priceTotalT){
        return Double.parseDouble(priceTotalT.replace("Item total: $", ""));
    }

    public double productPriceSum(){
        List<WebElement> productsPrices = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualProductsPrices = new ArrayList<>();
        double totalPrice = 0;

        for(WebElement productPrice: productsPrices){
            String productPriceText = productPrice.getText();
            double priceValue = getNumericPrice(productPriceText);
            //actualProductsPrices.add(priceValue);
            totalPrice += priceValue;
        }
        return totalPrice;
    }

    public double getPriceTotal(){
        WebElement priceTotal = driver.findElement(By.className("summary_subtotal_label"));
        String priceTotalText = priceTotal.getText();
        double priceTotalValue = getNumericPriceTotal(priceTotalText);

        return priceTotalValue;
    }

    public boolean isFinishButtonDisplayed(){
        boolean finishButtonIsDisplayed = finishButton.isDisplayed();
        return finishButtonIsDisplayed;
    }

    public void clickOnFinishButton(){

        finishButton.click();
    }
}
