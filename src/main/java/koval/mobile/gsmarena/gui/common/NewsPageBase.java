package koval.mobile.gsmarena.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gsmarena.gui.common.modals.BurgerMenuModalBase;
import koval.mobile.gsmarena.service.MyGSMArenaBurgerMenu;
import org.openqa.selenium.WebDriver;

public abstract class NewsPageBase extends AbstractPage{


    public NewsPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromBurgerMenu(MyGSMArenaBurgerMenu myGSMArenaBurgerMenu);
}
