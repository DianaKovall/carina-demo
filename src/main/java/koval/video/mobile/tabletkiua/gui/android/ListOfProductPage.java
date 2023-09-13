package koval.video.mobile.tabletkiua.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.tabletkiua.gui.common.ListOfProductPageBase;
import koval.video.mobile.tabletkiua.gui.common.SearchCatalogPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ListOfProductPageBase.class)
public class ListOfProductPage extends ListOfProductPageBase {

    public ListOfProductPage(WebDriver driver) {
        super(driver);
    }


}
