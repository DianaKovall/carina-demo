package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddedToCartPage extends AbstractPage {


    @FindBy(xpath = "//*[@class=\"product-drawer\"]/div[2]/div/div/div[2]/div")
    ExtendedWebElement productNameFromCart;

    @FindBy(xpath = "//*[@class=\"product-drawer\"]/div[2]/div/div/div[2]/p[1]")
    ExtendedWebElement productPriceFromCart;

    @FindBy(xpath = "//*[@class=\"product-drawer\"]/div[2]/div/div/div[2]/p[2]/span")
    ExtendedWebElement cartQuantity;

    public AddedToCartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameFromCart(){
        return productNameFromCart.getText();
    }

    public String getProductPriceFromCart(){
        return productPriceFromCart.getText();
    }

    public int getCartQuantity(){
        return Integer.parseInt(cartQuantity.getText());
    }
}
