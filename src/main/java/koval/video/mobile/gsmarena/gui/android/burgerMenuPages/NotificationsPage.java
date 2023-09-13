package koval.video.mobile.gsmarena.gui.android.burgerMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.NotificationsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NotificationsPageBase.class)
public class NotificationsPage extends NotificationsPageBase {
    public NotificationsPage(WebDriver driver) {
        super(driver);
    }
}
