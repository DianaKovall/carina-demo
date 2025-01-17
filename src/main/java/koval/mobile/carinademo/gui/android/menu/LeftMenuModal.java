package koval.mobile.carinademo.gui.android.menu;

import koval.mobile.carinademo.gui.common.menu.LeftMenuModalBase;
import koval.mobile.carinademo.service.enums.LeftMenu;
import koval.mobile.carinademo.service.interfaces.IConstantUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LeftMenuModalBase.class)
public class LeftMenuModal extends LeftMenuModalBase{

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement menuButton;

    /**
     * Elements from burger menu:
     * Web View, Charts, Maps, UI Elements in one webelement
     */
    @FindBy(xpath = "//android.widget.CheckedTextView[@text = '%s']")
    private ExtendedWebElement menuElement;

    public LeftMenuModal(WebDriver driver) {
        super(driver);
    }

    public LeftMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public LeftMenuModalBase openMenu() {
        menuButton.click();
        return initPage(getDriver(), LeftMenuModalBase.class);
    }

    @Override
    public AbstractPage openPage(LeftMenu menu) {
        menuButton.click();
        menuElement.format(menu.getPageName()).click();
            return initPage(getDriver(), menu.getClassName());
    }

    @Override
    public boolean isElementPresent(LeftMenu menu) {
        return menuElement.format(menu.getPageName()).isElementPresent(IConstantUtils.TIMEOUT_FIVE);
    }



}
