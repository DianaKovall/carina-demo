package koval.video.mobile.gsmarena.gui.android.phoneTabs;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.HistoryPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HistoryPageBase.class)
public class HistoryPage extends HistoryPageBase {
    public HistoryPage(WebDriver driver) {
        super(driver);
    }
}
