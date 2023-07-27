package koval.video.mobile.gsmarena.gui.android.buttomMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.android.modals.BurgerMenuModal;
import koval.video.mobile.gsmarena.gui.android.modals.ButtomMenuModal;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.NewsPageBase;
import koval.video.mobile.gsmarena.service.enums.ButtomMenuItems;
import koval.video.mobile.gsmarena.service.enums.MyGSMArenaMenuItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open Drawer\"]")
    BurgerMenuModal burgerMenuModal;

    @FindBy(id = "com.gsmarena.android:id/navigation")
    ButtomMenuModal buttomMenuModal;

    public NewsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public AbstractPage openPageFromBurgerMenu(MyGSMArenaMenuItems myGSMArenaMenuItems) {
        return burgerMenuModal.openPageFromBurgerMenu(myGSMArenaMenuItems);
    }

    @Override
    public AbstractPage openPageFromButtomMenu(ButtomMenuItems buttomMenuItems) {
        return buttomMenuModal.openPageFromMenu(buttomMenuItems);

    }

}
