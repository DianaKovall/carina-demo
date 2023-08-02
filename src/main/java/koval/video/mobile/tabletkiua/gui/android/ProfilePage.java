package koval.video.mobile.tabletkiua.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.tabletkiua.gui.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(id = "com.tabletkiua.tabletki:id/tv_name")
    ExtendedWebElement profileName;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isUserSuccessfullyLoggedIn() {
        return profileName.getText().replaceAll(SPACE_FIELD, EMPTY_FIELD).equals(R.TESTDATA.get("tabletkiua_username"));

    }

}
