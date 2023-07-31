package koval.video.mobile.gsmarena.gui.android.burgerMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.video.mobile.gsmarena.service.IConstants.TWENTY_TIMEOUT;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(xpath = "//android.view.View[@content-desc=\"LOGOUT\"]")
    ExtendedWebElement logoutButton;

    @FindBy(id = "android:id/button1")
    ExtendedWebElement okButton;


    @FindBy(xpath = "//*[@resource-id='content']/android.widget.TextView[@text=\"%s - user account\"]")
    ExtendedWebElement profileLabel;


    @FindBy(xpath = "//*[@resource-id=\"list-brands\"]/android.widget.TextView[@text=\"Favorite devices\"]/following-sibling::android.widget.ListView/android.view.View/android.view.View/android.view.View")
    ExtendedWebElement favoriteDeviceName;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLogoutButton() {
        logoutButton.click();
        okButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public boolean isUserSuccessfullyLogged() {
        return profileLabel.format(R.TESTDATA.get("gsmarena_username")).isElementPresent(TWENTY_TIMEOUT);
    }

    @Override
    public String getFavoriteDeviceName(){
        return favoriteDeviceName.getText();
    }


}
