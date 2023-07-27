package koval.video.mobile.gsmarena.gui.android.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.modals.BurgerMenuModalBase;
import koval.video.mobile.gsmarena.service.enums.MyGSMArenaMenuItems;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BurgerMenuModalBase.class)
public class BurgerMenuModal extends BurgerMenuModalBase {

    @FindBy(xpath = "//*[@resource-id=\"com.gsmarena.android:id/design_menu_item_text\" and @text='%s']")
    ExtendedWebElement menuItemByText;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open Drawer\"]")
    ExtendedWebElement burgerMenuModal;


    public BurgerMenuModal(WebDriver driver) {
        super(driver);
    }

    public BurgerMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public AbstractPage openPageFromBurgerMenu(MyGSMArenaMenuItems myGSMArenaMenuItems) {
        burgerMenuModal.click();
        menuItemByText.format(myGSMArenaMenuItems.getPageName()).click();
        return initPage(getDriver(), myGSMArenaMenuItems.getClassName());
    }

}
