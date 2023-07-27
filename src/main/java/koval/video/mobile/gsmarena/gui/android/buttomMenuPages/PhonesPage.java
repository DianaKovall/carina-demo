package koval.video.mobile.gsmarena.gui.android.buttomMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.SearchResultsPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhonesPageBase.class)
public class PhonesPage extends PhonesPageBase {

    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.view.View/android.widget.EditText")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.view.View/android.widget.Button")
    private ExtendedWebElement goButton;

    public PhonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PhonesPageBase enterSearchKeyword(String searchKeyword) {
        searchBar.type(searchKeyword);
        return initPage(getDriver(), PhonesPageBase.class);
    }

    @Override
    public SearchResultsPageBase clickOnGoButton() {
        goButton.click();
        return initPage(getDriver(), SearchResultsPageBase.class);
    }
}
