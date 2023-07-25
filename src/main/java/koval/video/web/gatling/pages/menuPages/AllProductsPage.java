package koval.video.web.gatling.pages.menuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gatling.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends AbstractPage {

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[1]/div[2]/p/a[text()=\"Add to cart\"]")
    ExtendedWebElement addToCartFirstElementButton;


    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[1]/a/h4")
    ExtendedWebElement firstProductName;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[1]/p[2]")
    ExtendedWebElement firstProductPrice;
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div/p[3]/a[1][text()=\"View cart\"]")
    ExtendedWebElement viewCartButton;

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstProductName() {
        return firstProductName.getText();
    }

    public String getFirstProductPrice() {
        return firstProductPrice.getText();
    }

    public AllProductsPage addFirstProductToCart() {
        addToCartFirstElementButton.click();
        return new AllProductsPage(driver);
    }


    public CartPage openCartPage() {
        viewCartButton.click();
        return new CartPage(driver);
    }


}
