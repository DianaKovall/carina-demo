package koval.video.web.wish.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyWishAbstractPage extends AbstractPage {

    @FindBy(xpath = ".//iframe")
    ExtendedWebElement cookiesFrame;

    public MyWishAbstractPage(WebDriver driver) {
        super(driver);
    }


    public SignInPage acceptCookies() {
        CookiesPage cookiesPage = new CookiesPage(driver);
        driver.switchTo().frame(cookiesFrame.getElement());
        cookiesPage.acceptCookies();

        getDriver().switchTo().defaultContent();
        return new SignInPage(driver);
    }

}
