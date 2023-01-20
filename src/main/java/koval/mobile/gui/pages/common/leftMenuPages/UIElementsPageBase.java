package koval.mobile.gui.pages.common.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;

public abstract class UIElementsPageBase extends AbstractPage {

    public UIElementsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProfileImagePresent();
}
