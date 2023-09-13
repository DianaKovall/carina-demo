package koval.video.mobile.tabletkiua.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.tabletkiua.gui.common.LoginPageBase;
import koval.video.mobile.tabletkiua.gui.common.MainPageBase;
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
    public MainPageBase clickOnLogin() {
        throw new NotImplementedException();
    }

}
