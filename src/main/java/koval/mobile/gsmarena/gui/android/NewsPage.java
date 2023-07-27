package koval.mobile.gsmarena.gui.android;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.android.modals.BurgerMenuModal;
import koval.mobile.gsmarena.gui.common.NewsPageBase;
import koval.mobile.gsmarena.gui.common.modals.BurgerMenuModalBase;
import koval.mobile.gsmarena.service.MyGSMArenaBurgerMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open Drawer\"]")
    private BurgerMenuModal burgerMenuModalBase;


    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPageFromBurgerMenu(MyGSMArenaBurgerMenu myGSMArenaBurgerMenu) {

        return burgerMenuModalBase.openPageFromBurgerMenu(myGSMArenaBurgerMenu);
    }

}
