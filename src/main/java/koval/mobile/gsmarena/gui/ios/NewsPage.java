package koval.mobile.gsmarena.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.NewsPageBase;
import koval.mobile.gsmarena.gui.common.modals.BurgerMenuModalBase;
import koval.mobile.gsmarena.service.MyGSMArenaBurgerMenu;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BurgerMenuModalBase openPageFromBurgerMenu(MyGSMArenaBurgerMenu myGSMArenaBurgerMenu) {
        throw new NotImplementedException();
    }
}
