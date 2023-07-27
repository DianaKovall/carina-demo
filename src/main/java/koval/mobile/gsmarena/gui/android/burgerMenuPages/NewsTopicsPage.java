package koval.mobile.gsmarena.gui.android.burgerMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.NewsTopicsPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsTopicsPageBase.class)
public class NewsTopicsPage extends NewsTopicsPageBase {
    public NewsTopicsPage(WebDriver driver) {
        super(driver);
    }
}
