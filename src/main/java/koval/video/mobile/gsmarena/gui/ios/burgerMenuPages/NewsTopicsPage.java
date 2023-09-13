package koval.video.mobile.gsmarena.gui.ios.burgerMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.NewsTopicsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NewsTopicsPageBase.class)
public class NewsTopicsPage extends NewsTopicsPageBase {
    public NewsTopicsPage(WebDriver driver) {
        super(driver);
    }

}
