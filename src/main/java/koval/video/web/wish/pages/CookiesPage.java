package koval.video.web.wish.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CookiesPage extends AbstractPage {


    @FindBy(xpath = "/html/body/div[8]/div[1]/div/div[3]/a[1]")
    ExtendedWebElement acceptCookiesButton;



    @FindBy(xpath = "/html/body/div[8]/div[1]/div/div[4]/a")
    ExtendedWebElement closeCookiesPopUpButton;


    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage acceptCookies(){
        acceptCookiesButton.click(10);
        closeCookiesPopUpButton.click(20);
        return new SignInPage(driver);
    }

}
