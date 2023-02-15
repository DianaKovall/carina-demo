package koval.carinademo.mobile.gui.android.leftMenuPages;

import koval.carinademo.mobile.gui.common.leftMenuPages.MapPageBase;
import koval.carinademo.mobile.service.enums.LeftMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    @FindBy(className = "/*[@resource-id='com.solvd.carinademoapplication:id/toolbar']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@content-desc='Google Map']")
    private ExtendedWebElement mapImage;

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(LeftMenu.MAP.getPageName());
    }

    @Override
    public boolean isMapImagePresent(long timeOut) {
        return mapImage.isElementPresent(timeOut);
    }
}