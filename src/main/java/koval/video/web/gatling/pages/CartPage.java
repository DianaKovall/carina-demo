package koval.video.web.gatling.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "/html/body/div/div/div[3]/table/tbody/tr[2]/td[1]")
    ExtendedWebElement productName;


    @FindBy(xpath = "/html/body/div/div/div[3]/table/tbody/tr[2]/td[3]/span")
    ExtendedWebElement productQuantity;


    @FindBy(xpath = "/html/body/div/div/div[3]/table/tbody/tr[3]/td[2]")
    ExtendedWebElement totalPrice;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/table/tbody/tr[4]/td[2]/a")
    ExtendedWebElement checkoutButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }


    public boolean isProductAdded(String productNameString) {
        return productName.isElementPresent(20) &&
                productName.getText().equals(productNameString);
    }

    public int getProductQuantity() {
        return Integer.parseInt(productQuantity.getText());
    }

    public String getProductPrice() {
        return totalPrice.getText();
    }


    public CheckoutConfirmationPage clickOnCheckoutButton()
    {
        checkoutButton.click();
        return new CheckoutConfirmationPage(driver);
    }

}
