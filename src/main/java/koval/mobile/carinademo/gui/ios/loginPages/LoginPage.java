package koval.mobile.carinademo.gui.ios.loginPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.carinademo.service.enums.Gender;
import koval.mobile.carinademo.gui.common.loginPages.LoginPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import koval.mobile.carinademo.gui.common.leftMenuPages.WebViewPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase typeName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase typePassword(String password) {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase selectGender(Gender gender) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isGenderChecked(Gender gender) {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox() {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox(boolean status) {
        throw new NotImplementedException();
    }

    @Override
    public WebViewPageBase clickLoginBtn() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLoginBtnActive() {
        throw new NotImplementedException();
    }

}
