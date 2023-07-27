package koval.mobile.gsmarena.gui.common.burgerMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isUserLoggedSuccessfully();

    public abstract LoginPageBase clickLogoutButton();
}
