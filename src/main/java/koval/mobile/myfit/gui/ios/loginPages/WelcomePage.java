package koval.mobile.myfit.gui.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.loginPages.AboutMePageBase;
import koval.mobile.myfit.gui.common.loginPages.WelcomePageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public AboutMePageBase clickLoginBtn() {
        throw new NotImplementedException();
    }

}
