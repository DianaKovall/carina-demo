package koval.video.mobile.gsmarena;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.video.mobile.gsmarena.gui.common.DeviceInformationPageBase;
import koval.video.mobile.gsmarena.gui.common.ForgottenPasswordPageBase;
import koval.video.mobile.gsmarena.gui.common.SearchResultsPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.NewsPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.ProfilePageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import koval.video.mobile.gsmarena.service.enums.ButtomMenuItems;
import koval.video.mobile.gsmarena.service.enums.MyGSMArenaMenuItems;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class GSMArenaMobileTestVideo implements IAbstractTest {


    private final String SEARCH_KEYWORD = "Samsung";

    private final String DEVICE_NAME = "Samsung Galaxy A54";


    public NewsPageBase login(){
        NewsPageBase newsPageBase = initPage(getDriver(), NewsPageBase.class);
        LoginPageBase loginPageBase = (LoginPageBase) newsPageBase.openPageFromBurgerMenu(MyGSMArenaMenuItems.LOGIN);

        if (!loginPageBase.isPageOpened()) {
            ProfilePageBase profilePageBase = initPage(getDriver(), ProfilePageBase.class);
            profilePageBase.clickOnLogoutButton();
        }

        loginPageBase.enterValidCredentials();
       return  loginPageBase.clickOnLoginButton();
    }

    @Test()
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        NewsPageBase newsPageBase = initPage(getDriver(), NewsPageBase.class);
        LoginPageBase loginPageBase = (LoginPageBase) newsPageBase.openPageFromBurgerMenu(MyGSMArenaMenuItems.LOGIN);

        if (!loginPageBase.isPageOpened()) {
            ProfilePageBase profilePageBase = initPage(getDriver(), ProfilePageBase.class);
            profilePageBase.clickOnLogoutButton();
        }

        loginPageBase.enterValidCredentials();
        newsPageBase = loginPageBase.clickOnLoginButton();
        ProfilePageBase profilePageBase = (ProfilePageBase) newsPageBase.openPageFromBurgerMenu(MyGSMArenaMenuItems.PROFILE);
        Assert.assertTrue(profilePageBase.isUserSuccessfullyLogged(), "[ PROFILE PAGE ] User was not successfully logged!");

    }

    @Test()
    @MethodOwner(owner = "dkoval")
    public void searchTest() {
        NewsPageBase newsPageBase = login();
        PhonesPageBase phonesPageBase = (PhonesPageBase) newsPageBase.openPageFromButtomMenu(ButtomMenuItems.PHONES);

        phonesPageBase.enterSearchKeyword(SEARCH_KEYWORD);
        SearchResultsPageBase searchResultsPageBase = phonesPageBase.clickOnGoButton();
        Assert.assertTrue(searchResultsPageBase.isPageOpened(SEARCH_KEYWORD), "[ SEARCH RESULTS PAGE ] Page is not opened!");
        Assert.assertTrue(searchResultsPageBase.isSearchedResultsAsExpected(SEARCH_KEYWORD), "[ SEARCH RESULTS PAGE ] List of items is not as expected!");

    }


    @Test()
    @MethodOwner(owner = "dkoval")
    public void forgotPasswordTest() {
        NewsPageBase newsPageBase = initPage(getDriver(), NewsPageBase.class);
        LoginPageBase loginPageBase = (LoginPageBase) newsPageBase.openPageFromBurgerMenu(MyGSMArenaMenuItems.LOGIN);

        if (!loginPageBase.isPageOpened()) {
            ProfilePageBase profilePageBase = initPage(getDriver(), ProfilePageBase.class);
            profilePageBase.clickOnLogoutButton();
        }

        ForgottenPasswordPageBase forgottenPasswordPageBase = loginPageBase.clickOnForgetPasswordLink();
        forgottenPasswordPageBase.enterEmail();
        forgottenPasswordPageBase.clickOnSubmitButton();
        Assert.assertTrue(forgottenPasswordPageBase.isResetPasswordConfirmMessagePresent(),
                "[ FORGOTTEN PASSWORD PAGE ] Password reset confirmation message is not displayed!");

    }


    @Test()
    @MethodOwner(owner = "dkoval")
    public void addToWishListTest() {
        NewsPageBase newsPageBase = login();
        PhonesPageBase phonesPageBase = (PhonesPageBase) newsPageBase.openPageFromButtomMenu(ButtomMenuItems.PHONES);
        phonesPageBase.enterSearchKeyword(DEVICE_NAME);
        SearchResultsPageBase searchResultsPageBase = phonesPageBase.clickOnGoButton();
        DeviceInformationPageBase deviceInformationPageBase = searchResultsPageBase.clickOnDeviceBlock(DEVICE_NAME);
        deviceInformationPageBase.clickOnBecomeFanButton();
        phonesPageBase = deviceInformationPageBase.clickOnBackButton();
        ProfilePageBase profilePageBase = (ProfilePageBase) phonesPageBase.openPageFromBurgerMenu(MyGSMArenaMenuItems.PROFILE);
        Assert.assertEquals(profilePageBase.getFavoriteDeviceName(), DEVICE_NAME, String.format("[ PROFILE PAGE ] Item %s was not added to wishlist!", DEVICE_NAME));
    }


    @Test()
    @MethodOwner(owner = "dkoval")
    public void sortTest() {
        NewsPageBase newsPageBase = login();
    }

}
