package koval.video.web.wish;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.video.web.wish.pages.SignInPage;
import koval.video.web.wish.pages.WelcomePage;
import org.testng.annotations.Test;

public class WishWebTest implements IAbstractTest {


    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
       welcomePage.open();


        SignInPage signInPage = welcomePage.clickOnSignInButton();
        signInPage.enterValidCredentials();
    }

}
