package koval.video.mobile.gsmarena.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.ForgottenPasswordPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ForgottenPasswordPageBase.class)
public class ForgottenPasswordPage extends ForgottenPasswordPageBase {
    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ForgottenPasswordPageBase enterEmail() {
        throw new NotImplementedException();
    }

    @Override
    public ForgottenPasswordPageBase clickOnSubmitButton() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isResetPasswordConfirmMessagePresent() {
        throw new NotImplementedException();
    }
}
