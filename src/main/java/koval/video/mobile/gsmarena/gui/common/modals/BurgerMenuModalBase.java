package koval.video.mobile.gsmarena.gui.common.modals;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class BurgerMenuModalBase extends AbstractPage {
    public BurgerMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public BurgerMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

}
