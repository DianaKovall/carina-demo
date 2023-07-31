package koval.video.mobile.gsmarena.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.mobile.gsmarena.gui.android.ForgottenPasswordPage;
import org.openqa.selenium.WebDriver;

public abstract class ForgottenPasswordPageBase extends AbstractPage {
    public ForgottenPasswordPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ForgottenPasswordPageBase enterEmail();

    public abstract ForgottenPasswordPageBase clickOnSubmitButton();

    public abstract boolean isResetPasswordConfirmMessagePresent();
}
