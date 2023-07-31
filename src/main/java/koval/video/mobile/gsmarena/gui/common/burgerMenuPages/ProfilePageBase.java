package koval.video.mobile.gsmarena.gui.common.burgerMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage {
    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickOnLogoutButton();

    public abstract boolean isUserSuccessfullyLogged();

    public abstract String getFavoriteDeviceName();
}
