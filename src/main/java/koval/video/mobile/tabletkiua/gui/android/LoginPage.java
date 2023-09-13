package koval.video.mobile.tabletkiua.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.tabletkiua.gui.common.LoginPageBase;
import koval.video.mobile.tabletkiua.gui.common.MainPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//*[@resource-id=\"com.tabletkiua.tabletki:id/et_email\"]/android.view.ViewGroup/android.widget.EditText")
    ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@resource-id=\"com.tabletkiua.tabletki:id/et_password\"]/android.view.ViewGroup/android.widget.EditText")
    ExtendedWebElement passwordField;

    @FindBy(id = "com.tabletkiua.tabletki:id/btn_layout_log_in")
    ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public LoginPageBase enterValidCredentials() {
        emailField.type(R.TESTDATA.get("tabletkiua_mail"), TEN_TIMEOUT);
        passwordField.type(R.TESTDATA.get("tabletkiua_password"), TEN_TIMEOUT);
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public MainPageBase clickOnLogin(){
        loginButton.click(TWENTY_TIMEOUT);
        return initPage(getDriver(), MainPageBase.class);
    }

}
