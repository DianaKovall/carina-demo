package koval.video.mobile.gsmarena.gui.common.modals;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ButtomMenuModalBase extends AbstractPage  {
    public ButtomMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public ButtomMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

}
