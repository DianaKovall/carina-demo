package koval.video.mobile.gsmarena.gui.ios.burgerMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.NotificationsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NotificationsPageBase.class)
public class NotificationsPage extends NotificationsPageBase {
    public NotificationsPage(WebDriver driver) {
        super(driver);
    }
}
