package koval.video.mobile.tabletkiua.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.tabletkiua.gui.common.LoginPageBase;
import koval.video.mobile.tabletkiua.gui.common.MainPageBase;
import koval.video.mobile.tabletkiua.gui.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @FindBy(id = "com.tabletkiua.tabletki:id/ll_notification")
    ExtendedWebElement loginNotification;

    @FindBy(id = "com.tabletkiua.tabletki:id/iv_avatar_view")
    ExtendedWebElement profileIcon;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLoginNotification() {
        loginNotification.click(TWENTY_TIMEOUT);
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public ProfilePageBase clickOnProfileIcon() {
        profileIcon.click(TWENTY_TIMEOUT);
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
