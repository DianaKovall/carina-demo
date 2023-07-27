package koval.video.mobile.gsmarena.gui.ios.buttomMenuPages;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.SearchResultsPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PhonesPageBase.class)
public class PhonesPage extends PhonesPageBase {
    public PhonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PhonesPageBase enterSearchKeyword(String searchKeyword) {
        throw new NotImplementedException();
    }

    @Override
    public SearchResultsPageBase clickOnGoButton() {
        throw new NotImplementedException();
    }
}
