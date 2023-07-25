package koval.mobile.gsmarena.gui.android.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.modals.BurgerMenuModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BurgerMenuModalBase.class)
public class BurgerMenuModal extends BurgerMenuModalBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open Drawer\"]")
    private ExtendedWebElement burgerMenuModalBase;

    @FindBy(xpath = "//*[@resource-id=\"com.gsmarena.android:id/design_menu_item_text\" and @text='%s']")
    private ExtendedWebElement menuItemByText;

    public BurgerMenuModal(WebDriver driver) {
        super(driver);
    }

    public BurgerMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public BurgerMenuModalBase openBurgerMenu() {
        burgerMenuModalBase.click();
        return initPage(getDriver(), BurgerMenuModalBase.class);
    }

}
