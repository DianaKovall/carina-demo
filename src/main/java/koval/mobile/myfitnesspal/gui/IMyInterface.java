package koval.mobile.myfitnesspal.gui;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import koval.mobile.myfitnesspal.utils.IConstantUtils;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public interface IMyInterface extends IConstantUtils, IMobileUtils, IAbstractTest {

    AdbService adbService = new AdbService();

    Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    default void pressKey(int keyCodeValue) {
        getDevice(getDriver()).pressKey(keyCodeValue);
    }


    default PhoneHomePageBase goHome() {
        pressKey(HOME_PAGE);
        return initPage(getDriver(), PhoneHomePageBase.class);
    }

}
