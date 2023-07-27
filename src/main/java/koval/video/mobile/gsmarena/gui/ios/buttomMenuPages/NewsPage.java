package koval.video.mobile.gsmarena.gui.ios.buttomMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.NewsPageBase;
import koval.video.mobile.gsmarena.service.enums.ButtomMenuItems;
import koval.video.mobile.gsmarena.service.enums.MyGSMArenaMenuItems;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPageFromBurgerMenu(MyGSMArenaMenuItems myGSMArenaMenuItems) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageFromButtomMenu(ButtomMenuItems buttomMenuItems) {
        throw new NotImplementedException();
    }
}
