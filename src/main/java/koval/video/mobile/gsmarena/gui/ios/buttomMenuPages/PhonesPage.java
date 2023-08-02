package koval.video.mobile.gsmarena.gui.ios.buttomMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.SearchResultsPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import koval.video.mobile.gsmarena.service.enums.MyGSMArenaMenuItems;
import koval.video.mobile.gsmarena.service.enums.PhoneTabs;
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

    @Override
    public AbstractPage openPageFromBurgerMenu(MyGSMArenaMenuItems myGSMArenaMenuItems) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openTabByContext(PhoneTabs phoneTabs) {
        throw new NotImplementedException();
    }
}
