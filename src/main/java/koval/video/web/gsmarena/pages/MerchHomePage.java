package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MerchHomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"fw-section-featured-collection-0\"]/section//a/div/div[2]/div/button")
    ExtendedWebElement seeMoreButton;

    public MerchHomePage(WebDriver driver) {
        super(driver);
        setPageURL("https://merch.gsmarena.com/");
    }

    public DetailedProductPage clickOnSeeMoreButton()
    {
        seeMoreButton.click();
        return new DetailedProductPage(driver);
    }

}
