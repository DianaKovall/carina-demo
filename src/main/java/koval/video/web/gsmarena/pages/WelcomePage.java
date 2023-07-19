package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gsmarena.modals.LoginModal;
import koval.video.web.gsmarena.modals.MenuModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div")
    MenuModal menuModal;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public LoginModal clickOnLoginButton()
    {
       return menuModal.clickOnLoginButton();
    }


}
