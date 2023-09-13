package koval.video.mobile.gsmarena.gui.ios.phoneTabs;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.BrandsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrandsPageBase.class)
public class BrandsPage extends BrandsPageBase {
    public BrandsPage(WebDriver driver) {
        super(driver);
    }
}
