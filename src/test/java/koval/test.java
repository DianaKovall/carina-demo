package koval;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.TestTag;
import com.zebrunner.carina.utils.R;
import koval.mobile.Apps;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import koval.mobile.myfitnesspal.service.enums.*;
import koval.video.mobile.gsmarena.service.enums.PhoneTabs;
import koval.web.gsmarena.service.enums.Size;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import koval.web.myfitnesspal.service.factories.foodFactory.FoodFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class test implements IMyInterface {

    private static final List<String> FOOD = Arrays.asList("Apple", "Bread", "Water", "Cherries");

    private static final int FOOD_MEAL_INDEX = new Random().nextInt(FOOD.size());

    private static final String MEAL_NAME = "meal_" + RandomStringUtils.randomAlphabetic(FIVE_COUNT);

    private static final String APP_NAME = AppAndWidgets.FITNESSPAL.getAppName();

    private static final String WIDGET_NAME = AppAndWidgets.FITNESSPAL.getFirstWidget();

    private static final String SURVEY_PLANS_URL = "docs.google.com/forms/d/e/1FAIpQLSdXJDLwt3_Ugbnnc1XDwdzoUObCeZxtypxCnM4rBSEWu9tNzQ/viewform";

    @Test(groups = {"logout"})
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void loginSimpleUserTest() {

            Apps.downloadAndroidApp(AdbService.AppPackage.MY_FITNESS_PAL);

            adbService.installApp(AdbService.AppPackage.MY_FITNESS_PAL);

            adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

            adbService.startApp(AdbService.AppPackage.MY_FITNESS_PAL);

            hideKeyboard();

            WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
            welcomePageBase.notificationSendPopUpIfPresent(ALLOW_ANSWER);
            Assert.assertTrue(welcomePageBase.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

            LogInPageBase loginPageBase = welcomePageBase.logIn();
            Assert.assertTrue(loginPageBase.isPageOpened(), "[ LOGIN PAGE ] Login page is not opened!");

            loginPageBase.typeMail(R.TESTDATA.get("fitnessPal_mail"));
            loginPageBase.typePassword(R.TESTDATA.get("fitnessPal_password"));
            loginPageBase.clickLoginButton();
            loginPageBase.closeLoginFailedPopUpIfPresent();

            loginPageBase.closeNoSubscriptionsPopUpIfPresent();
            loginPageBase.closeUserTutorialBoxIfPresent();

    }


    @Test(groups = {"logout"})
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void test() {



        String[] currentLocaleString = R.CONFIG.getProperties().getProperty("locale").split("_");
        Locale currentLocale = new Locale(currentLocaleString[0], currentLocaleString[1]);

    }




    @Test()
    public void TEST() {


        LOGGER.info(PhoneTabs.POPULAR.toString());
    }


}

