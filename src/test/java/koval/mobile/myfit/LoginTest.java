package koval.mobile.myfit;


import koval.mobile.myfit.gui.IMyInterface;
import koval.mobile.myfit.service.AdbService;
import koval.mobile.myfit.gui.common.loginPages.AboutMePageBase;
import koval.mobile.myfit.gui.common.loginPages.TrackActivitiesPageBase;
import koval.mobile.myfit.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfit.service.enums.TrackYourActivitiesAnswer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class LoginTest implements IMyInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    AdbService adbService = new AdbService();

    @BeforeMethod
    public void login() {

        adbService.setDarkMode(NO_ANSWER);

        adbService.clearAppCache(AdbService.AppPackage.GOOGLE_FIT);

        adbService.startApp(AdbService.AppPackage.GOOGLE_FIT);

        WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePageBase.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        AboutMePageBase aboutMePageBase = welcomePageBase.clickLoginBtn();
        Assert.assertTrue(aboutMePageBase.isPageOpened(), "[ ABOUT YOU PAGE ] About You page is not opened!");

        TrackActivitiesPageBase trackActivitiesPageBase = aboutMePageBase.clickNextBtn();
        Assert.assertTrue(trackActivitiesPageBase.isPageOpened(), "[ TRACK ACTIVITIES PAGE ] Track Activities page is not opened!");
        trackActivitiesPageBase.clickOnAnswerBtn(TrackYourActivitiesAnswer.NO);

    }

    @AfterMethod
    public void logout() {
        adbService.clearAppCache(AdbService.AppPackage.GOOGLE_FIT);
    }

}
