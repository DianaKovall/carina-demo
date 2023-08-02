package koval.video.mobile.gsmarena.gui.ios.phoneTabs;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.PopularPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PopularPageBase.class)
public class PopularPage extends PopularPageBase {
    public PopularPage(WebDriver driver) {
        super(driver);
    }
}
