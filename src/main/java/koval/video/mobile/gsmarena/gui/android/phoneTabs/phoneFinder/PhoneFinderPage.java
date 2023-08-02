package koval.video.mobile.gsmarena.gui.android.phoneTabs.phoneFinder;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder.PhoneFinderPageBase;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder.PhoneFinderResultsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhoneFinderPageBase.class)
public class PhoneFinderPage extends PhoneFinderPageBase {

    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.widget.Button")
    ExtendedWebElement brandButton;

    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    ExtendedWebElement brandField;

    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[@text=\"\uE901%s\"]")
    ExtendedWebElement brandCheckField;


    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.view.View/android.view.View[2]/android.widget.Button")
    ExtendedWebElement showResultsButton;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PhoneFinderPageBase setBrandName(String brandName){
        brandButton.click();
        brandField.type(brandName);
        brandCheckField.format(brandName).click();
        return initPage(getDriver(), PhoneFinderPageBase.class);
    }

    @Override
    public PhoneFinderResultsPageBase clickOnShowResultsButton(){
        showResultsButton.click();
        return initPage(getDriver(), PhoneFinderResultsPageBase.class);
    }

}
