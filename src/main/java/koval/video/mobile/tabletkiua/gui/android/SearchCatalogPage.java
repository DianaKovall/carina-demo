package koval.video.mobile.tabletkiua.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.tabletkiua.gui.common.SearchCatalogPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchCatalogPageBase.class)
public class SearchCatalogPage extends SearchCatalogPageBase {

    public SearchCatalogPage(WebDriver driver) {
        super(driver);
    }


}
