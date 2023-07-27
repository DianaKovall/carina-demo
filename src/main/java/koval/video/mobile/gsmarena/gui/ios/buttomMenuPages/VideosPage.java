package koval.video.mobile.gsmarena.gui.ios.buttomMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.VideosPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = VideosPageBase.class)
public class VideosPage extends VideosPageBase {
    public VideosPage(WebDriver driver) {
        super(driver);
    }
}
