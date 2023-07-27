package koval.video.mobile.gsmarena.gui.android.buttomMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.ReviewsPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ReviewsPageBase.class)
public class ReviewsPage extends ReviewsPageBase {
    public ReviewsPage(WebDriver driver) {
        super(driver);
    }
}
