package koval.mobile.gsmarena.gui.common.modals;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gsmarena.service.MyGSMArenaBurgerMenu;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class BurgerMenuModalBase extends AbstractPage implements IMobileUtils {

    public BurgerMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public BurgerMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract AbstractPage openPageFromBurgerMenu(MyGSMArenaBurgerMenu myGSMArenaBurgerMenu);
}
