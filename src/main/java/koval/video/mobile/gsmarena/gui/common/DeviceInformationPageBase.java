package koval.video.mobile.gsmarena.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import org.openqa.selenium.WebDriver;

public abstract class DeviceInformationPageBase extends AbstractPage {
    public DeviceInformationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DeviceInformationPageBase clickOnBecomeFanButton();

    public abstract PhonesPageBase clickOnBackButton();
}
