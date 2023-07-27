package koval.video.mobile.gsmarena.gui.ios.burgerMenuPages;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.ProfilePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLogoutButton() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isUserSuccessfullyLogged() {
        throw new NotImplementedException();
    }
}
