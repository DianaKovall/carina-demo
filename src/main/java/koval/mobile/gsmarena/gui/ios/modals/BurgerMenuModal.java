package koval.mobile.gsmarena.gui.ios.modals;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.modals.BurgerMenuModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BurgerMenuModalBase.class)
public class BurgerMenuModal extends BurgerMenuModalBase {
    public BurgerMenuModal(WebDriver driver) {
        super(driver);
    }

    public BurgerMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public BurgerMenuModalBase openBurgerMenu() {
        throw new NotImplementedException();
    }

}
