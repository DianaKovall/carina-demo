package koval.mobile.myfitnesspal.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;

import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPage extends DashboardPageBase {


    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.myfitnesspal.android:id/action_bar_root")
    private ExtendedWebElement popUpNoSubscriptionsMessage;

    @FindBy(xpath = "//android.view.View[@content-desc='%s']")
    private ExtendedWebElement itemByContentDesc;

    @FindBy(xpath = "//android.view.View[1]/android.widget.Button")
    private ExtendedWebElement exitTutorialButton;

    @FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View")
    private ExtendedWebElement userTutorialBox;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {

        return itemByContentDesc.format("Calories card").isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }


    @Override
    public boolean isUserPremium() {

        return !itemByText.format("Go Premium").isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public SignUpPageBase lastMealPopUpSkip() {

        if (itemByText.format("Select a meal.").isElementPresent(TIMEOUT_FIVE)) {
            itemByText.format("Skip").click();
        }

        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public DashboardPageBase closeNoSubscriptionsPopUp() {

        if (popUpNoSubscriptionsMessage.isElementPresent(TIMEOUT_FIVE)) {
            itemByText.format("Cancel").click();
        }
        return initPage(getDriver(), DashboardPageBase.class);
    }

    @Override
    public DashboardPageBase closeUserTutorialBox() {

        if (userTutorialBox.isElementPresent(TIMEOUT_FIVE)) {
            exitTutorialButton.click();
        }
        return initPage(getDriver(), DashboardPageBase.class);
    }


}
