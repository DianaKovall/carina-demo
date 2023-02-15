package koval.carinademo.mobile.gui.android.leftMenuPages;

import koval.carinademo.mobile.gui.common.leftMenuPages.UIElementsPageBase;
import koval.carinademo.mobile.service.enums.LeftMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {

    @FindBy(className = "/*[@resource-id='com.solvd.carinademoapplication:id/toolbar']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement title;

    @FindBy(id = "com.solvd.carinademoapplication:id/imageView")
    private ExtendedWebElement profileImage;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(LeftMenu.UI_ELEMENTS.getPageName());
    }

    @Override
    public boolean isProfileImagePresent(long timeOut) {
        return profileImage.isElementPresent(timeOut);
    }
}