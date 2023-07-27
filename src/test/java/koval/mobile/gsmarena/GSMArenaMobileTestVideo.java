package koval.mobile.gsmarena;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.mobile.gsmarena.gui.common.NewsPageBase;
import koval.mobile.gsmarena.gui.android.burgerMenuPages.ProfilePage;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.ProfilePageBase;
import koval.mobile.gsmarena.service.MyGSMArenaBurgerMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GSMArenaMobileTestVideo implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        NewsPageBase newsPageBase = initPage(getDriver(), NewsPageBase.class);
        LoginPageBase loginPageBase = (LoginPageBase) newsPageBase.openPageFromBurgerMenu(MyGSMArenaBurgerMenu.LOGIN);
        if(!loginPageBase.isPageOpened())
        {
            ProfilePageBase profilePage = initPage(getDriver(), ProfilePageBase.class);
            profilePage.clickLogoutButton();
        }
        loginPageBase.enterValidCredentials();
        newsPageBase = loginPageBase.clickOnLoginButton();
        ProfilePageBase profilePage = (ProfilePage) newsPageBase.openPageFromBurgerMenu(MyGSMArenaBurgerMenu.PROFILE);
        Assert.assertTrue(profilePage.isUserLoggedSuccessfully(), "[ PROFILE PAGE ] User was not successfully logged!");
        profilePage.clickLogoutButton();
    }
}
