package koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;


import java.util.List;

public abstract class PhoneFinderResultsPageBase extends AbstractPage implements IMobileUtils {



    public PhoneFinderResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getResultsList();

    public abstract boolean isProductSortedCorrectly(List<String> resultsNameString, String brandName);
}
