package koval.video.mobile.gsmarena.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.ForgottenPasswordPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.video.mobile.gsmarena.service.IConstants.*;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ForgottenPasswordPageBase.class)
public class ForgottenPasswordPage extends ForgottenPasswordPageBase {

    @FindBy(xpath = "//*[@resource-id='email']")
    ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@resource-id='nick-submit']")
    ExtendedWebElement submitButton;


    @FindBy(xpath= "//*[@resource-id=\"content\"]/android.widget.TextView[3][@text=\"%s\"]")
    ExtendedWebElement confirmationMessage;

    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public ForgottenPasswordPageBase enterEmail() {
        emailField.type(R.TESTDATA.get("gsmarena_mail"), TWENTY_TIMEOUT);
        return initPage(getDriver(), ForgottenPasswordPageBase.class);
    }

    @Override
    public ForgottenPasswordPageBase clickOnSubmitButton() {
        submitButton.click(TWENTY_TIMEOUT);
        return initPage(getDriver(), ForgottenPasswordPageBase.class);
    }

    @Override
    public boolean isResetPasswordConfirmMessagePresent(){
        return confirmationMessage.format(PASSWORD_RESET_CONFIRM_MESSAGE).isElementPresent(TWENTY_TIMEOUT);
    }



}
