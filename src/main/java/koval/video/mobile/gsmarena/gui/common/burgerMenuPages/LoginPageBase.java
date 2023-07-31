package koval.video.mobile.gsmarena.gui.common.burgerMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.mobile.gsmarena.gui.common.ForgottenPasswordPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.NewsPageBase;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase enterValidCredentials();

    public abstract NewsPageBase clickOnLoginButton();

    public abstract ForgottenPasswordPageBase clickOnForgetPasswordLink();
}
