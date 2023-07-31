package koval.video.mobile.gsmarena.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.DeviceInformationPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DeviceInformationPageBase.class)
public class DeviceInformationPage extends DeviceInformationPageBase {
    public DeviceInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DeviceInformationPageBase clickOnBecomeFanButton() {
     throw new NotImplementedException();
    }

    @Override
    public PhonesPageBase clickOnBackButton() {
        throw new NotImplementedException();
    }
}
