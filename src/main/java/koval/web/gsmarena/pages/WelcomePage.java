package koval.web.gsmarena.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.gsmarena.modals.LoginModal;
import koval.web.gsmarena.modals.MenuModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"header\"]/div/div")
    MenuModal menuModal;

    public WelcomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.gsmarena.com/");
    }


    public LoginModal clickOnLoginButton() {
        return menuModal.clickOnLoginButton();
    }


}
