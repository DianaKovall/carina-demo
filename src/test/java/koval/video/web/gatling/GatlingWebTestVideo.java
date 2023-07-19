package koval.video.web.gatling;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.video.web.gatling.pages.HomePage;
import koval.video.web.gatling.pages.LoginPage;
import koval.video.web.gatling.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GatlingWebTestVideo implements IAbstractTest {


    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        HomePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isUserLogged(), String.format("[ HOME PAGE ] User %s is not logged!", R.TESTDATA.get("gatling_username")));
    }

}
