package koval.video.mobile.gsmarena.gui.ios.phoneTabs;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.HistoryPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HistoryPageBase.class)
public class HistoryPage extends HistoryPageBase {
    public HistoryPage(WebDriver driver) {
        super(driver);
    }
}
