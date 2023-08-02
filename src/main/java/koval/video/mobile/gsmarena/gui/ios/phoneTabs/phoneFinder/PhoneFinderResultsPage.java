package koval.video.mobile.gsmarena.gui.ios.phoneTabs.phoneFinder;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder.PhoneFinderResultsPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PhoneFinderResultsPageBase.class)
public class PhoneFinderResultsPage extends PhoneFinderResultsPageBase {

    public PhoneFinderResultsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public List<String> getResultsList() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isProductSortedCorrectly(List<String> resultsNameString, String brandName) {
        throw new NotImplementedException();
    }


}
