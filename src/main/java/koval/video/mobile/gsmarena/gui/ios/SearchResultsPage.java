package koval.video.mobile.gsmarena.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.DeviceInformationPageBase;
import koval.video.mobile.gsmarena.gui.common.SearchResultsPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String searchKeyword) {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getSearchedItemsToList() {
       throw new NotImplementedException();
    }

    @Override
    public boolean isSearchedResultsAsExpected(String searchKeyword) {
        throw new NotImplementedException();
    }

    @Override
    public DeviceInformationPageBase clickOnDeviceBlock(String deviceBlockString) {
        throw new NotImplementedException();
    }
}
