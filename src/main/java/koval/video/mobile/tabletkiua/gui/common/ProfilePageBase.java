package koval.video.mobile.tabletkiua.gui.common;

import koval.video.mobile.tabletkiua.services.enums.MyAbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends MyAbstractPage {
    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isUserSuccessfullyLoggedIn();
}
