package koval.video.web.gatling.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutConfirmationPage extends AbstractPage {

    @FindBy(xpath = "/html/body/div/div/div[3]/h3[text()=\"Checkout Confirmation\"]")
    ExtendedWebElement title;

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return title.isElementPresent(20);
    }

}
