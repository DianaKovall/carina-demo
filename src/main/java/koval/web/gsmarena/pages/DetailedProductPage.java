package koval.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.gsmarena.service.enums.Size;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DetailedProductPage extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"fw-section-product\"]/section/div/div[2]/div/div[2]/div/div/div[1]/span")
    ExtendedWebElement productPrice;

    @FindBy(xpath = "//*[@id=\"fw-section-product\"]/section/div/div[2]/div/div/div//h1")
    ExtendedWebElement productName;

    @FindBy(xpath = "//*[@id=\"fw-section-product\"]/section/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div/label[text()='%s']")
    ExtendedWebElement sizeButton;

    @FindBy(xpath = "//*[@class=\"product-info__cta\"]//button")
    ExtendedWebElement addToCartButton;

    public DetailedProductPage(WebDriver driver) {
        super(driver);
    }

    public DetailedProductPage selectSize(Size size) {
        sizeButton.format(size.name()).click();
        return new DetailedProductPage(driver);
    }

    public AddedToCartPage addToCart() {
        addToCartButton.click();
        return new AddedToCartPage(driver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

}
