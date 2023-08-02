package koval.video.mobile.tabletkiua.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.tabletkiua.gui.common.LoginPageBase;
import koval.video.mobile.tabletkiua.gui.common.MainPageBase;
import koval.video.mobile.tabletkiua.gui.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLoginNotification() {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase clickOnProfileIcon() {
        throw new NotImplementedException();
    }

}
