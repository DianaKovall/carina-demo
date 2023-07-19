package koval.video.web.wish.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CookiesPage extends AbstractPage {


    @FindBy(xpath = "/html/body/div[8]/div[1]/div/div[3]/a[1]")
    ExtendedWebElement acceptCookiesButton;

    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    public WelcomePage acceptCookies(){
        acceptCookiesButton.click(10);
        return new WelcomePage(driver);
    }

}
