package koval.mobile.myfitnesspal.gui.ios.phoneInterface;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneWidgetPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.Calories;
import koval.mobile.myfitnesspal.service.enums.WidgetSize;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PhoneHomePageBase.class)
public class PhoneHomePage extends PhoneHomePageBase {


    public PhoneHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int getCaloriesValueFromWidget(Calories calories) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage holdPhoneDesktop() {
        throw new NotImplementedException();
    }

    @Override
    public PhoneHomePageBase holdWidget(ExtendedWebElement widget) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSearchButtonPresent(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFitnessPalWidgetPresent(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase pressSearchButton() {
        throw new NotImplementedException();
    }

    @Override
    public DashboardPageBase openAppFromWidget() {
        throw new NotImplementedException();
    }

    @Override
    public PhoneWidgetPageBase tapWidgetButton() {
        throw new NotImplementedException();
    }


    @Override
    public PhoneHomePageBase deleteWidget(String widgetName) {
        throw new NotImplementedException();
    }

    @Override
    public PhoneHomePageBase resizeWidgetFromTo (WidgetSize actualSizeValue, WidgetSize desiredSizeValue) {
        throw new NotImplementedException();
    }

    @Override
    public PhoneWidgetPageBase searchForApp(String appName) {
        throw new NotImplementedException();
    }

}
