package koval.video.mobile.tabletkiua;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.video.mobile.tabletkiua.gui.common.LoginPageBase;
import koval.video.mobile.tabletkiua.gui.common.MainPageBase;
import koval.video.mobile.tabletkiua.gui.common.ProfilePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TabletkiuaMobileVideoTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        MainPageBase mainPageBase = initPage(getDriver(), MainPageBase.class);
        LoginPageBase loginPageBase = mainPageBase.clickOnLoginNotification();
        loginPageBase.enterValidCredentials();
        mainPageBase = loginPageBase.clickOnLogin();
        ProfilePageBase profilePageBase = mainPageBase.clickOnProfileIcon();
        Assert.assertTrue(profilePageBase.isUserSuccessfullyLoggedIn(), "[ PROFILE PAGE ] User was not logged in!");
    }

}
