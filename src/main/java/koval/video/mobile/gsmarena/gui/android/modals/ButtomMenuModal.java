package koval.video.mobile.gsmarena.gui.android.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.modals.ButtomMenuModalBase;
import koval.video.mobile.gsmarena.service.enums.ButtomMenuItems;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ButtomMenuModalBase.class)
public class ButtomMenuModal extends ButtomMenuModalBase {


    @FindBy(id = "com.gsmarena.android:id/navigation_%s")
    ExtendedWebElement menuItem;

    public ButtomMenuModal(WebDriver driver) {
        super(driver);
    }

    public ButtomMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public AbstractPage openPageFromMenu(ButtomMenuItems buttomMenuItems) {
        menuItem.format(buttomMenuItems.getIdPage()).click();
        return initPage(getDriver(), buttomMenuItems.getClassName());
    }

}
