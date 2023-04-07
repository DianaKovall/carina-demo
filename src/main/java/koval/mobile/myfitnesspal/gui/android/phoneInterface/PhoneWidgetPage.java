package koval.mobile.myfitnesspal.gui.android.phoneInterface;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneWidgetPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhoneWidgetPageBase.class)
public class PhoneWidgetPage extends PhoneWidgetPageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/widgets_search_bar_edit_text")
    private ExtendedWebElement searchWidgetField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.nexuslauncher:id/app_title' and @text='%s']")
    private ExtendedWebElement appTitle;

    @FindBy(xpath = "//*[@text='%s']/parent::*/*[@resource-id='com.google.android.apps.nexuslauncher:id/widget_preview_container']")
    private ExtendedWebElement widgetContainer;

    public PhoneWidgetPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public boolean isPageOpened(int timeout) {
        return itemByText.format(WIDGETS_STRING).isElementPresent(timeout);
    }

    @Override
    public boolean isPageOpened() {
        return isPageOpened(TIMEOUT_FIFTEEN);
    }

    @Override
    public PhoneHomePageBase addWidgetToDesktop(String appName, String widgetName) {

        searchWidgetField.type(appName);

        appTitle.format(appName).click();

        int centerX = getCenterX(widgetContainer.format(widgetName));

        int centerY = getCenterY(widgetContainer.format(widgetName));
        int upperY = (centerY - widgetContainer.format(widgetName).getLocation().getY()) / 2;
        int desiredY = centerY - upperY;

        adbService.holdElementByCoordinates(centerX, desiredY);

        return initPage(getDriver(), PhoneHomePageBase.class);
    }


}