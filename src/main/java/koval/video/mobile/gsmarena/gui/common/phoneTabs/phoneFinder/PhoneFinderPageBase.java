package koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PhoneFinderPageBase extends AbstractPage {
    public PhoneFinderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PhoneFinderPageBase setBrandName(String brandName);

    public abstract PhoneFinderResultsPageBase clickOnShowResultsButton();
}
