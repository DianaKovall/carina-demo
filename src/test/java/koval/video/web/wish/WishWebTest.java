package koval.video.web.wish;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.video.web.wish.pages.MyWishAbstractPage;
import koval.video.web.wish.pages.SignInPage;
import org.testng.annotations.Test;

public class WishWebTest implements IAbstractTest {


    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {

        MyWishAbstractPage myWishAbstractPage = new MyWishAbstractPage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        myWishAbstractPage.acceptCookies();
        signInPage.enterValidCredentials();
    }

}
