package koval.video.mobile.gsmarena.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchResultsPageBase extends AbstractPage implements IMobileUtils {
    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String searchKeyword);

    public abstract List<String> getSearchedItemsToList();

    public abstract boolean isSearchedResultsAsExpected(String searchKeyword);

    public abstract DeviceInformationPageBase clickOnDeviceBlock(String deviceBlockString);
}
