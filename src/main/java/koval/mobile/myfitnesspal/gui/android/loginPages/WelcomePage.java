package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import org.openqa.selenium.WebDriver;




@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemByText.format(SIGNUP).isElementPresent(TIMEOUT_TEN) && itemByText.format(LOGIN).isElementPresent(TIMEOUT_TEN);
    }

    @Override
    public SignUpPageBase signUp() {
        itemByText.format(SIGNUP).click(TIMEOUT_TEN);
        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public LogInPageBase logIn() {
        itemByText.format(LOGIN).click(TIMEOUT_TEN);

        return initPage(getDriver(), LogInPageBase.class);
    }

    @Override
    public AbstractPage clickButton(String buttonText) {

        itemByText.format(buttonText).click(TIMEOUT_TEN);
        return initPage(getDriver(), LogInPageBase.class);
    }

}
