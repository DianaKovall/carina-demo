package koval.video.mobile.gsmarena.gui.ios.modals;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.modals.ButtomMenuModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ButtomMenuModalBase.class)
public class ButtomMenuModal extends ButtomMenuModalBase {
    public ButtomMenuModal(WebDriver driver) {
        super(driver);
    }

    public ButtomMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

}
