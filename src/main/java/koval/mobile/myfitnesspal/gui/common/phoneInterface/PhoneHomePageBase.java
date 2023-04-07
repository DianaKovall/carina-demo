package koval.mobile.myfitnesspal.gui.common.phoneInterface;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import org.openqa.selenium.WebDriver;


public abstract class PhoneHomePageBase extends MyAbstractPage {

    public PhoneHomePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage holdPhoneDesktop();


    public abstract PhoneHomePageBase holdWidget(ExtendedWebElement widget);

    public abstract boolean isSearchButtonPresent(int timeout);

    public abstract boolean isFitnessPalWidgetPresent(int timeout);

    public abstract SearchFoodPageBase pressSearchButton();

    public abstract PhoneWidgetPageBase tapWidgetButton();

    public abstract PhoneHomePageBase deleteWidget(String widgetName);

    public abstract PhoneHomePageBase resizeWidgetByX(int sizeValue);
}