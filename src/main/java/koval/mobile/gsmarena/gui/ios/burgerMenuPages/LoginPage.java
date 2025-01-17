package koval.mobile.gsmarena.gui.ios.burgerMenuPages;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.NewsPageBase;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase enterValidCredentials() {
        throw new NotImplementedException();
    }

    @Override
    public NewsPageBase clickOnLoginButton() {
        throw new NotImplementedException();
    }
}
