package koval.mobile.gsmarena.gui.android.burgerMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.widget.TextView[1][contains(@text, \"%s - user account\")]")
    private ExtendedWebElement profileLabel;


    @FindBy(xpath = "//android.view.View[@content-desc=\"LOGOUT\"]")
    private ExtendedWebElement logoutButton;


    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okButton;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isUserLoggedSuccessfully() {
        return profileLabel.format(R.TESTDATA.get("gsmarena_username")).isElementPresent();
    }

    @Override
    public LoginPageBase clickLogoutButton() {
        logoutButton.click();
        okButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

}
