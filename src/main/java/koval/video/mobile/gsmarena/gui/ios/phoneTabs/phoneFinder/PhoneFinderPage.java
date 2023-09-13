package koval.video.mobile.gsmarena.gui.ios.phoneTabs.phoneFinder;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder.PhoneFinderPageBase;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder.PhoneFinderResultsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PhoneFinderPageBase.class)
public class PhoneFinderPage extends PhoneFinderPageBase {

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PhoneFinderPageBase setBrandName(String brandName) {
        throw new NotImplementedException();
    }

    @Override
    public PhoneFinderResultsPageBase clickOnShowResultsButton() {
        throw new NotImplementedException();
    }

}
