package koval.video.mobile.gsmarena.gui.android.burgerMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.NewsPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.video.mobile.gsmarena.service.IConstants.TWENTY_TIMEOUT;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "com.gsmarena.android:id/input_email")
    ExtendedWebElement emailField;

    @FindBy(id = "com.gsmarena.android:id/input_password")
    ExtendedWebElement passwordField;

    @FindBy(id = "com.gsmarena.android:id/btn_login")
    ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return emailField.isElementPresent(TWENTY_TIMEOUT) &&
                loginButton.isElementPresent(TWENTY_TIMEOUT);
    }

    @Override
    public LoginPageBase enterValidCredentials() {
        emailField.type(R.TESTDATA.get("gsmarena_mail"));
        passwordField.type(R.TESTDATA.get("gsmarena_password"));
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public NewsPageBase clickOnLoginButton() {
        loginButton.click();
        return initPage(getDriver(), NewsPageBase.class);
    }

}
