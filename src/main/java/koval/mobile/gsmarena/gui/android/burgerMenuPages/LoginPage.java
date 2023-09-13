package koval.mobile.gsmarena.gui.android.burgerMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gsmarena.gui.common.NewsPageBase;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {


    @FindBy(id="com.gsmarena.android:id/input_email")
    private ExtendedWebElement emailField;

    @FindBy(id="com.gsmarena.android:id/input_password")
    private ExtendedWebElement passwordField;

    @FindBy(id="com.gsmarena.android:id/btn_login")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase enterValidCredentials(){
        emailField.type(R.TESTDATA.get("gsmarena_mail"));
        passwordField.type(R.TESTDATA.get("gsmarena_password"));
        return initPage(getDriver(), LoginPageBase.class);
    }


    @Override
    public NewsPageBase clickOnLoginButton(){
        loginButton.click();
        return initPage(getDriver(), NewsPageBase.class);
    }

    @Override
    public boolean isPageOpened(){
        return loginButton.isElementPresent() && emailField.isElementPresent();
    }



}
