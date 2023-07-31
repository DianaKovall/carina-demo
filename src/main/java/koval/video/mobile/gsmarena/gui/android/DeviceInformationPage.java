package koval.video.mobile.gsmarena.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.DeviceInformationPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.video.mobile.gsmarena.service.IConstants.BECOME_A_FAN;
import static koval.video.mobile.gsmarena.service.IConstants.TWENTY_TIMEOUT;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DeviceInformationPageBase.class)
public class DeviceInformationPage extends DeviceInformationPageBase {


    @FindBy(xpath = "//android.view.View[@content-desc=\"\uE957540 %s\"]/android.view.View")
    ExtendedWebElement heartButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Desplazarse hacia arriba\"]")
    ExtendedWebElement backButton;

    public DeviceInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DeviceInformationPageBase clickOnBecomeFanButton(){
       ExtendedWebElement becomeFanButton = heartButton.format(BECOME_A_FAN);
        if(becomeFanButton.isElementPresent(TWENTY_TIMEOUT))
        {
            becomeFanButton.click();
        }
        return initPage(getDriver(), DeviceInformationPageBase.class);
    }

    @Override
    public PhonesPageBase clickOnBackButton(){
        backButton.click();
        return initPage(getDriver(), PhonesPageBase.class);
    }
}
